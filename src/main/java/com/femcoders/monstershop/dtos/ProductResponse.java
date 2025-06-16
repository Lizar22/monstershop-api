package com.femcoders.monstershop.dtos;

public record ProductResponse(
        String name,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured
) {
}
