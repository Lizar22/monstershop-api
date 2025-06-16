package com.femcoders.monstershop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String imageUrl;
    private double rating;
    private int reviewCount;
    private boolean featured;

    public Product() {
    }

    public Product(@NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "Name must contain min 2 and max 50 characters") String featured, @NotBlank(message = "Price is required") double reviewCount, @NotBlank("Image URL is required") String rating, @NotBlank("Rating is required") double imageUrl, double price, @NotBlank("Feature is required") boolean name) {
        this.featured = featured;
        this.reviewCount = reviewCount;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}
