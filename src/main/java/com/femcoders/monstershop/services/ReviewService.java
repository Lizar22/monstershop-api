package com.femcoders.monstershop.services;

import com.femcoders.monstershop.dtos.review.ReviewMapper;
import com.femcoders.monstershop.dtos.review.ReviewRequest;
import com.femcoders.monstershop.dtos.review.ReviewResponse;
import com.femcoders.monstershop.models.Product;
import com.femcoders.monstershop.models.Review;
import com.femcoders.monstershop.repositories.ProductRepository;
import com.femcoders.monstershop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found"));
        return product.getReviews().stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        Product product = productService.getProductObjectById(reviewRequest.productId());
        Review newReview = ReviewMapper.dtoToEntity(reviewRequest);
        newReview.setProduct(product);
        Review savedReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedReview);

    }


//    public ReviewResponse addReview(Long productId, ReviewRequest reviewRequest) {
//        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found"));
//        Review newreview = ReviewMapper.dtoToEntity(reviewRequest);
//        newreview.setProduct(product);
//        Review savedReview = reviewRepository.save(newreview);
//        return ReviewMapper.entityToDto(savedReview);
//    }
}
