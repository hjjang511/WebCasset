package com.project.webbackend.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.webbackend.Entity.MauBang;

import java.util.List;
import java.util.Optional;


@Repository
public interface MauBangRepository extends JpaRepository<MauBang, Long> {
    boolean existsByName(String name);
    Optional<MauBang> findByName(String name);

    @Query("SELECT p FROM MauBang p WHERE " +
    "(:keyword IS NULL OR :keyword = '' OR p.name LIKE %:keyword%)")
    Page<MauBang> searchProducts
    (@Param("keyword") String keyword, Pageable pageable);
    @Query("SELECT p FROM MauBang p LEFT JOIN FETCH p.img WHERE p.id = :mauBangid")
    Optional<MauBang> getImg(@Param("mauBangid") Long mauBangid);
    @Query("SELECT p FROM MauBang p WHERE p.id IN :productIds")
    List<MauBang> findProductsByIds(@Param("productIds") List<Long> productIds);
}
