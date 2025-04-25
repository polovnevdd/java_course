package com.glovo.service.impl;

import com.glovo.dto.OrderDto;
import com.glovo.dto.ProductDto;

import com.glovo.mapper.OrderMapper;
import com.glovo.mapper.OrderMapperImpl;
import com.glovo.mapper.ProductMapper;
import com.glovo.mapper.ProductMapperImpl;
import com.glovo.repository.OrderRepository;
import com.glovo.repository.ProductRepository;
import com.glovo.repository.entity.Order;
import com.glovo.repository.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class DefaultGlovoServiceTest {
    public static final Integer ORDER_ID = 1;
    public static final Integer FIRST_PRODUCT_ID = 1;
    public static final Integer SECOND_PRODUCT_ID = 2;
    public static final String PRODUCT_NAME = "pizza";
    public static final Double PRODUCT_PRICE = 11.11;
    public static final Integer PRODUCT_QUANTITY = 2;

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private DefaultOrderService orderService;

    private ProductMapper productMapper;
    private OrderMapper orderMapper;
    private OrderDto orderDto;
    private ProductDto firstProductDto;
    private ProductDto secondProductDto;
    private Order order;
    private Product firstProduct;
    private Product secondProduct;
    private LocalDateTime nowDateTime;

    @BeforeEach
    void setUp() {
        orderMapper = new OrderMapperImpl();
        productMapper = new ProductMapperImpl();
        orderService = new DefaultOrderService(orderMapper, productMapper, orderRepository, productRepository);

        firstProductDto = new ProductDto(FIRST_PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY);
        firstProduct = new Product(FIRST_PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY, order);
        nowDateTime = LocalDateTime.now();
        orderDto = new OrderDto(ORDER_ID, nowDateTime, nowDateTime, List.of(firstProductDto));
        order = new Order(ORDER_ID, nowDateTime, nowDateTime, List.of(firstProduct));

        secondProductDto = new ProductDto(SECOND_PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY);
        secondProduct = new Product(SECOND_PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY, order);
    }

    @Test
    void shouldGetOrderSuccessfully() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));

        OrderDto foundOrderDto = orderService.getOrder(ORDER_ID);

        assertEquals(orderDto, foundOrderDto);
    }

    @Test
    void shouldCreateOrderSuccessfully() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderDto createdOrderDto = orderService.createOrder(orderDto);

        verify(orderRepository).save(any(Order.class));
        assertEquals(ORDER_ID, createdOrderDto.getOrderId());
    }

    @Test
    void shouldUpdateOrderSuccessfully() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderDto updatedOrderDTO = orderService.updateOrder(orderDto);

        verify(orderRepository).save(any(Order.class));
        assertEquals(ORDER_ID, updatedOrderDTO.getOrderId());
    }

    @Test
    void shouldAddProductToOrderSuccessfully() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));
        Order updatedOrder = new Order(ORDER_ID, nowDateTime, nowDateTime, List.of(firstProduct, secondProduct));
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        OrderDto updatedOrderDTO = orderService.addProductToOrder(ORDER_ID, secondProductDto);

        verify(productRepository).save(any(Product.class));
        verify(orderRepository).save(any(Order.class));
        assertEquals(ORDER_ID, updatedOrderDTO.getOrderId());
        assertEquals(SECOND_PRODUCT_ID, updatedOrderDTO.getProducts().stream()
                .filter(p -> p.getProductId().equals(SECOND_PRODUCT_ID)).findFirst().get().getProductId());
    }

    @Test
    void shouldRemoveProductFromOrderSuccessfully() {
        when(productRepository.findById(FIRST_PRODUCT_ID)).thenReturn(Optional.of(firstProduct));
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));
        Order updatedOrder = new Order(ORDER_ID, nowDateTime, nowDateTime, List.of());
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        OrderDto updatedOrderDTO = orderService.removeProductFromOrder(ORDER_ID, FIRST_PRODUCT_ID);

        verify(productRepository).delete(firstProduct);
        verify(orderRepository).save(any(Order.class));
        assertEquals(ORDER_ID, updatedOrderDTO.getOrderId());
        assertTrue(updatedOrderDTO.getProducts().isEmpty());
    }

    @Test
    void shouldDeleteOrderSuccessfully() {
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.of(order));

        orderService.deleteOrder(ORDER_ID);

        verify(orderRepository).delete(order);
    }
}