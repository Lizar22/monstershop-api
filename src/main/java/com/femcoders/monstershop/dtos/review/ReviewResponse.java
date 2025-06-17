package com.femcoders.monstershop.dtos.review;

public record ReviewResponse(
        String username,
        double rating,
        String body
) {
}
