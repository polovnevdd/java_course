package com.glovo.service;

import com.glovo.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductByName(String name);
}
