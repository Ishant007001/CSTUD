package com.xyz.product.service;

import com.xyz.product.model.Product;
import com.xyz.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = Product.builder()
                .id(1L)
                .name("Laptop")
                .description("Gaming Laptop")
                .price(1200.0)
                .stock(10)
                .build();
    }

    @Test
    void testSaveProduct() {
        when(productRepository.save(product)).thenReturn(product);
        Product saved = productService.saveProduct(product);
        assertEquals("Laptop", saved.getName());
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Optional<Product> found = productService.getProductById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        assertEquals(1, productService.getAllProducts().size());
    }
}
