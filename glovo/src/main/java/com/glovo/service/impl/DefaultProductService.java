package com.glovo.service.impl;

import com.glovo.dto.ProductDto;
import com.glovo.mapper.OrderMapper;
import com.glovo.mapper.ProductMapper;
import com.glovo.repository.OrderRepository;
import com.glovo.repository.ProductRepository;
import com.glovo.repository.entity.Order;
import com.glovo.repository.entity.Product;
import com.glovo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getProductByName(String name) {
        List<Product> products = productRepository.findAllByName(name);
        return products.stream().map(productMapper::toProductDto).toList();
    }
}
