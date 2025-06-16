package com.femcoders.monstershop.controllers;

import com.femcoders.monstershop.dtos.ProductRequest;
import com.femcoders.monstershop.dtos.ProductResponse;
import com.femcoders.monstershop.models.Product;
import com.femcoders.monstershop.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> addEvent(@Valid @RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
    }
}
