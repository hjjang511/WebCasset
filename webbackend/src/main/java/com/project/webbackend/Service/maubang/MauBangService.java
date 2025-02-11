package com.project.webbackend.Service.maubang;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.webbackend.Entity.MauBang;
import com.project.webbackend.Entity.MauBangImage;
import com.project.webbackend.Repository.MauBangImageRepository;
import com.project.webbackend.Repository.MauBangRepository;
import com.project.webbackend.Response.maubang.MauBangResponse;
import com.project.webbackend.dtos.MauBangDTO;
import com.project.webbackend.dtos.MauBangImageDTO;
import com.project.webbackend.exceptions.DataNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MauBangService {
     @Autowired
    private MauBangRepository mauBangRepository;

    @Autowired
    private MauBangImageRepository mauBangImageRepository;
    
    private static String UPLOADS_FOLDER = "uploads";

    @Transactional
    public MauBang createMauBang(MauBangDTO MauBangDTO) throws DataAccessException {
        MauBang newMauBang = MauBang.builder()
                .name(MauBangDTO.getName())
                .price(MauBangDTO.getPrice())
                .build();
        return mauBangRepository.save(newMauBang);
    }

    public MauBang getMauBangById(long MauBangId) throws Exception {
        Optional<MauBang> optionalMauBang = mauBangRepository.getImg(MauBangId);
        if(optionalMauBang.isPresent()) {
            return optionalMauBang.get();
        }
        throw new DataNotFoundException("Cannot find MauBang with id =" + MauBangId);
    }
    @Transactional
    public MauBang updateProduct(
            long id,
            MauBangDTO MauBangDTO
    )
            throws Exception {
        MauBang existingMauBang = getMauBangById(id);
        if(existingMauBang != null) {
            //copy các thuộc tính từ DTO -> MauBang
            //Có thể sử dụng ModelMapper
            if(MauBangDTO.getName() != null && !MauBangDTO.getName().isEmpty()) {
                existingMauBang.setName(MauBangDTO.getName());
            }
            return mauBangRepository.save(existingMauBang);
        }
        return null;
    }

    @Transactional
    public void deleteMauBang(long id) {
        Optional<MauBang> optionalProduct = mauBangRepository.findById(id);
        optionalProduct.ifPresent(mauBangRepository::delete);
    }


    public boolean existsByName(String name) {
        return mauBangRepository.existsByName(name);
    }

    @Transactional
    public MauBangImage createProductImage(
            Long productId,
            MauBangImageDTO productImageDTO) throws Exception {
        MauBang existingProduct = mauBangRepository
                .findById(productId)
                .orElseThrow(() ->
                new DataNotFoundException(
                    "Cannot find product with id: "+productImageDTO.getMaubangid()));
        MauBangImage newProductImage = MauBangImage.builder()
                .mauBang(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        if (existingProduct.getThumbnail() == null ) {
                    existingProduct.setThumbnail(newProductImage.getImageUrl());
        }
        mauBangRepository.save(existingProduct);
        return mauBangImageRepository.save(newProductImage);
    }
    
    public List<MauBang> findProductsByIds(List<Long> productIds) {
        return mauBangRepository.findProductsByIds(productIds);
    }
    public void deleteFile(String filename) throws IOException {
        // Đường dẫn đến thư mục chứa file
        java.nio.file.Path uploadDir = Paths.get(UPLOADS_FOLDER);
        // Đường dẫn đầy đủ đến file cần xóa
        java.nio.file.Path filePath = uploadDir.resolve(filename);

        // Kiểm tra xem file tồn tại hay không
        if (Files.exists(filePath)) {
            // Xóa file
            Files.delete(filePath);
        } else {
            throw new FileNotFoundException("File not found: " + filename);
        }
    }
    private boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }

    public String storeFile(MultipartFile file) throws IOException {
        if (!isImageFile(file) || file.getOriginalFilename() == null) {
            throw new IOException("Invalid image format");
        }
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        // Thêm UUID vào trước tên file để đảm bảo tên file là duy nhất
        //String uniqueFilename = UUID.randomUUID().toString() + "_" + filename; //old code, not good
        String uniqueFilename = UUID.randomUUID().toString() + "_" + System.nanoTime(); // Convert nanoseconds to microseconds
        // Đường dẫn đến thư mục mà bạn muốn lưu file
        java.nio.file.Path uploadDir = Paths.get(UPLOADS_FOLDER);
        // Kiểm tra và tạo thư mục nếu nó không tồn tại
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        // Đường dẫn đầy đủ đến file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
        // Sao chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }
    public Page<MauBangResponse> getAllProducts(String keyword, PageRequest pageRequest) {
        // Lấy danh sách sản phẩm theo trang (page), giới hạn (limit), và categoryId (nếu có)
        Page<MauBang> productsPage;
        productsPage = mauBangRepository.searchProducts(keyword, pageRequest);
        return productsPage.map(MauBangResponse::fromProduct);        
}
}
