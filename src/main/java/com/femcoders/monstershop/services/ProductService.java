package com.femcoders.monstershop.services;

import com.femcoders.monstershop.dtos.ProductMapper;
import com.femcoders.monstershop.dtos.ProductResponse;
import com.femcoders.monstershop.models.Product;
import com.femcoders.monstershop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }
}
