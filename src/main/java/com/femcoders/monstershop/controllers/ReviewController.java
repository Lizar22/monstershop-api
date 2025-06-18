package com.femcoders.monstershop.controllers;

import com.femcoders.monstershop.dtos.review.ReviewRequest;
import com.femcoders.monstershop.dtos.review.ReviewResponse;
import com.femcoders.monstershop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByProductId(@PathVariable Long productId) {
        List<ReviewResponse> reviews = reviewService.getReviewsByProductId(productId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestParam Long productId, @Valid @RequestBody ReviewRequest reviewRequest) {
        ReviewResponse addedReview = reviewService.addReview(productId, reviewRequest);
        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }
}
