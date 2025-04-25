package com.glovo.service;

import com.glovo.dto.OrderDto;
import com.glovo.dto.ProductDto;

public interface OrderService {
    OrderDto getOrder(Integer orderId);
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto);
    OrderDto addProductToOrder(Integer orderId, ProductDto productDto);
    OrderDto removeProductFromOrder(Integer orderId, Integer productId);
    void deleteOrder(Integer orderId);
}
