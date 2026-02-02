package com.aquarium.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.ProductPromotion;

public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, Long> {
    Optional<ProductPromotion> findByProductIdAndPromotionId(Long productId, Long promotionId);

    void deleteByProductIdAndPromotionId(Long productId, Long promotionId);

    boolean existsByProductIdAndPromotionId(Long productId, Long promotionId);
}
