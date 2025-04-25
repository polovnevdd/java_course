package com.glovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {
    private Integer orderId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<ProductDto> products;
}
