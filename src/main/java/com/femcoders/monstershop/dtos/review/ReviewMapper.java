package com.femcoders.monstershop.dtos.review;

import com.femcoders.monstershop.models.Review;

public class ReviewMapper {
    public static Review dtoToEntity (ReviewRequest dto) {
        return new Review(dto.username(), dto.rating(), dto.body());
    }

    public static ReviewResponse entityToDto (Review review) {
        return new ReviewResponse(review.getUsername(), review.getRating(), review.getBody());
    }
}
