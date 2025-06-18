package com.femcoders.monstershop.services;

import com.femcoders.monstershop.dtos.product.ProductMapper;
import com.femcoders.monstershop.dtos.product.ProductRequest;
import com.femcoders.monstershop.dtos.product.ProductResponse;
import com.femcoders.monstershop.models.Product;
import com.femcoders.monstershop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public ProductResponse getByProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
        return ProductMapper.entityToDto(product);
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
        updatedProduct.setName(productRequest.name());
        updatedProduct.setPrice(productRequest.price());
        updatedProduct.setImageUrl(productRequest.imageUrl());
        updatedProduct.setRating(productRequest.rating());
        updatedProduct.setReviewCount(productRequest.reviewCount());
        updatedProduct.setFeatured(productRequest.featured());
        Product newProduct = productRepository.save(updatedProduct);
        return ProductMapper.entityToDto(newProduct);
    }

    public void deleteProduct(Long id) {
        getByProductById(id);
        productRepository.deleteById(id);
    }

    public Product getProductObjectById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }
}