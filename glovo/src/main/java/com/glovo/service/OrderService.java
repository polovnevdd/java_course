package com.glovo.service;

import com.glovo.dto.OrderDto;
import com.glovo.dto.ProductDto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    OrderDto getOrder(Integer orderId);
    List<OrderDto> getOrdersBeforeDate(LocalDateTime dateTime);
    List<OrderDto> getOrdersByName(String name);
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto);
    OrderDto addProductToOrder(Integer orderId, ProductDto productDto);
    OrderDto removeProductFromOrder(Integer orderId, Integer productId);
    void deleteOrder(Integer orderId);
}
