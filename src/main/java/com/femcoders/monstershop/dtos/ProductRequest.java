package com.femcoders.monstershop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must contain min 2 and max 50 characters")
        String name,
        @NotNull(message = "Price is required")
        double price,
        @NotBlank(message = "Image URL is required")
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured
) {
}
