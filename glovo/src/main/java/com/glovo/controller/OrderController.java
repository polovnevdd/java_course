package com.glovo.controller;

import com.glovo.dto.OrderDto;
import com.glovo.dto.ProductDto;
import com.glovo.service.OrderService;
import com.glovo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/glovo")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("orderId") Integer orderId) {
        OrderDto orderDto = orderService.getOrder(orderId);
        if (orderDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<List<ProductDto>> getProductByName(@PathVariable("productName") String productName) {
        List<ProductDto> products = productService.getProductByName(productName);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/order/before/{dateTime}")
    public ResponseEntity<List<OrderDto>> getOrderBeforeTime(@PathVariable("dateTime") LocalDateTime dateTime){
        List<OrderDto> orders = orderService.getOrdersBeforeDate(dateTime);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/orders/product/{name}")
    public ResponseEntity<List<OrderDto>> getOrderByProduct(@PathVariable("name") String name){
        List<OrderDto> orders = orderService.getOrdersByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrderDto = orderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDto);
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        OrderDto updatedOrderDto = orderService.updateOrder(orderDto);
        if (updatedOrderDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedOrderDto);
    }

    @PatchMapping("/order/{orderId}/product")
    public ResponseEntity<OrderDto> addProduct(@PathVariable("orderId") Integer orderId, @RequestBody ProductDto productDto) {
        OrderDto orderDto = orderService.addProductToOrder(orderId, productDto);
        if (orderDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @DeleteMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<OrderDto> updateProduct(@PathVariable("orderId") Integer orderId, @PathVariable("productId") Integer productId) {
        OrderDto orderDto = orderService.removeProductFromOrder(orderId, productId);
        if (orderDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}
