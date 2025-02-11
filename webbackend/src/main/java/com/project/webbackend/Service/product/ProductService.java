package com.project.webbackend.Service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.webbackend.Entity.MauBang;
import com.project.webbackend.Entity.Product;
import com.project.webbackend.Repository.MauBangRepository;
import com.project.webbackend.Repository.ProductRepository;
import com.project.webbackend.Repository.UserRepository;
import com.project.webbackend.dtos.ProductDTO;
import com.project.webbackend.exceptions.DataNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService{
    private final ProductRepository productRepository;
    private final MauBangRepository mauBangRepository;
    @Transactional
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException {
        MauBang existingMauBang = mauBangRepository
                .findById(productDTO.getMaubangid())
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "Cannot find mau bang with id: "+productDTO.getMaubangid()));

        Product newProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .otpName(productDTO.getOtpName())
                .matA(productDTO.getMatA())
                .matB(productDTO.getMatB())
                .mauBang(existingMauBang)
                .build();
        return productRepository.save(newProduct);
    }



    public List<Product> findProductsByIds(List<Long> productIds) {
        return productRepository.findProductsByIds(productIds);
    }

    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

}
