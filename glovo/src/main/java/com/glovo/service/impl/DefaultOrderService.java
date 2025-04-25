package com.glovo.service.impl;

import com.glovo.dto.OrderDto;
import com.glovo.dto.ProductDto;
import com.glovo.mapper.OrderMapper;
import com.glovo.mapper.ProductMapper;
import com.glovo.repository.OrderRepository;
import com.glovo.repository.ProductRepository;
import com.glovo.repository.entity.Order;
import com.glovo.repository.entity.Product;
import com.glovo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderDto getOrder(Integer orderId) {
        Optional<Order> foundOrderOptional = orderRepository.findById(orderId);
        return foundOrderOptional.map(orderMapper::toOrderDto).orElse(null);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        orderDto.setCreateDate(nowDateTime);
        orderDto.setUpdateDate(nowDateTime);
        Order order = orderMapper.toOrder(orderDto);
        return saveOrderAndProducts(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Optional<Order> oldOrderOptional = orderRepository.findById(orderDto.getOrderId());
        if (oldOrderOptional.isPresent()) {
            Order order = orderMapper.toOrder(orderDto);
            order.setCreateDate(oldOrderOptional.get().getCreateDate());
            order.setUpdateDate(LocalDateTime.now());
            return saveOrderAndProducts(order);
        } else {
            return null;
        }
    }

    @Override
    public OrderDto addProductToOrder(Integer orderId, ProductDto productDto) {
        Optional<Order> foundOrderOptional = orderRepository.findById(orderId);
        if (foundOrderOptional.isPresent()) {
            Order order = foundOrderOptional.get();
            Product product = productMapper.toProduct(productDto);
            product.setOrder(order);
            productRepository.save(product);

            order.setUpdateDate(LocalDateTime.now());
            Order updatedOrder = orderRepository.save(order);
            return orderMapper.toOrderDto(updatedOrder);
        } else {
            return null;
        }
    }

    @Override
    public OrderDto removeProductFromOrder(Integer orderId, Integer productId) {
        Optional<Product> productToDelete = productRepository.findById(productId);
        productToDelete.ifPresent(productRepository::delete);

        Optional<Order> foundOrderOptional = orderRepository.findById(orderId);
        if (foundOrderOptional.isPresent()) {
            Order order = foundOrderOptional.get();
            order.setUpdateDate(LocalDateTime.now());
            Order savedOrder = orderRepository.save(order);
            return orderMapper.toOrderDto(savedOrder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Optional<Order> foundOrderOptional = orderRepository.findById(orderId);
        foundOrderOptional.ifPresent(orderRepository::delete);
    }

    private OrderDto saveOrderAndProducts(Order order) {
        order.getProducts().forEach(p -> p.setOrder(order));
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderDto(savedOrder);
    }
}
