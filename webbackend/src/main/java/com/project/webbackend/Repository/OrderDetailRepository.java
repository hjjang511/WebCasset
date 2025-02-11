package com.project.webbackend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.webbackend.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId(Long orderId);
}
