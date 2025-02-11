package com.project.webbackend.Service.orderdetails;



import java.util.List;

import com.project.webbackend.Entity.OrderDetail;
import com.project.webbackend.dtos.OrderDetailDTO;
import com.project.webbackend.exceptions.DataNotFoundException;

public interface IOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO newOrderDetail) throws Exception;
    OrderDetail getOrderDetail(Long id) throws DataNotFoundException;
    OrderDetail updateOrderDetail(Long id, OrderDetailDTO newOrderDetailData)
            throws DataNotFoundException;
    void deleteById(Long id);
    List<OrderDetail> findByOrderId(Long orderId);
}
