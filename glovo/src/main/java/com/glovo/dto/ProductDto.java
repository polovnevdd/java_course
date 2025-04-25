package com.glovo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Integer productId;
    private String name;
    private Double price;
    private Integer quantity;
}
