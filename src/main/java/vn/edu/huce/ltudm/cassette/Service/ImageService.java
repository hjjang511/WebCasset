package vn.edu.huce.ltudm.cassette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.edu.huce.ltudm.cassette.Entity.Image;
import vn.edu.huce.ltudm.cassette.Repository.ImageRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    // Thư mục lưu trữ hình ảnh
    private static final String UPLOAD_DIR = "../image";

    public void uploadImage(MultipartFile file) throws IOException {
        // Lưu file vào thư mục
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath);

        // Lưu thông tin về hình ảnh vào cơ sở dữ liệu
        Image imageEntity = new Image();
        imageEntity.setName(file.getOriginalFilename());
        imageRepository.save(imageEntity);
    }

    public byte[] downloadImage(int id) throws IOException {
        // Tìm kiếm thông tin về hình ảnh trong cơ sở dữ liệu
        Image imageEntity = imageRepository.findById(id).orElse(null);
        if (imageEntity == null) {
            throw new RuntimeException("Image not found");
        }

        // Đọc file từ thư mục lưu trữ
        Path filePath = Paths.get(UPLOAD_DIR).resolve(imageEntity.getName());
        return Files.readAllBytes(filePath);
    }
}