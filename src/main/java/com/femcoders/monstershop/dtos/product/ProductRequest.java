package com.femcoders.monstershop.dtos.product;

import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must contain min 2 and max 50 characters")
        String name,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
        @DecimalMax(value = "150.0", message = "Price top is 150€")
        Double price,

        @NotBlank(message = "Image URL is required")
        String imageUrl,

        double rating,
        int reviewCount,
        boolean featured
) {
}
