package com.aquarium.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aquarium.models.tables.Product;
import com.aquarium.models.tables.ProductPromotion;
import com.aquarium.models.tables.Promotion;
import com.aquarium.repositories.ProductPromotionRepository;

@Service
public class ProductPromotionService {

    @Autowired
    private ProductPromotionRepository productPromotionRepository;

    @Transactional
    public void assignProductToPromotion(Product product, Promotion promotion) {
        if (!productPromotionRepository.existsByProductIdAndPromotionId(product.getId(), promotion.getId())) {
            ProductPromotion pp = new ProductPromotion();
            pp.setProduct(product);
            pp.setPromotion(promotion);
            productPromotionRepository.save(pp);
        }
    }

    @Transactional
    public void removeProductFromPromotion(Long productId, Long promotionId) {
        productPromotionRepository.deleteByProductIdAndPromotionId(productId, promotionId);
    }

    public boolean isProductAssigned(Long productId, Long promotionId) {
        return productPromotionRepository.existsByProductIdAndPromotionId(productId, promotionId);
    }
}
