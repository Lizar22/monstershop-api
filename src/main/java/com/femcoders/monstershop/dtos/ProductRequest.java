package com.femcoders.monstershop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must contain min 2 and max 50 characters")
        String name,
        @NotBlank(message = "Price is required")
        double price,
        @NotBlank("Image URL is required")
        String imageUrl,
        @NotBlank("Rating is required")
        double rating,
        @NotBlank("Review count is required")
        int reviewCount,
        @NotBlank("Feature is required")
        boolean featured
) {
}
