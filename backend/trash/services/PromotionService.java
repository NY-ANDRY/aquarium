package com.aquarium.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarium.models.tables.Promotion;
import com.aquarium.repositories.PromotionRepository;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion savePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public Promotion getPromotion(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
}
