package com.femcoders.monstershop.repositories;

import com.femcoders.monstershop.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
