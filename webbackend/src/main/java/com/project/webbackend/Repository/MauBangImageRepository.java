package com.project.webbackend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.webbackend.Entity.MauBangImage;

import java.util.Optional;

public interface MauBangImageRepository extends JpaRepository<MauBangImage, Long> {
    Optional<MauBangImage> findByMauBangId(Long mauBangId);
}
