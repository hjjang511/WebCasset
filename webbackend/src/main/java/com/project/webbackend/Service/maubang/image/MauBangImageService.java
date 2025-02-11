package com.project.webbackend.Service.maubang.image;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.project.webbackend.Entity.MauBangImage;
import com.project.webbackend.Repository.MauBangImageRepository;
import com.project.webbackend.exceptions.DataNotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MauBangImageService {
    private MauBangImageRepository productImageRepository;
     @Transactional
    public MauBangImage deleteProductImage(Long id) throws Exception {
        Optional<MauBangImage> productImage = productImageRepository.findById(id);
        if(productImage.isEmpty()) {
            throw new DataNotFoundException(
                    String.format("Cannot find product image with id: %ld", id)
            );
        }
        productImageRepository.deleteById(id);
        return productImage.get();
    }
}
