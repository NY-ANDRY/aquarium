package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.aquarium.dto.fish.FishDailyAlimentDTO;
import com.aquarium.dto.fish.FishDailyNutrientTotalDTO;
import com.aquarium.models.logics.NutrientQtt;
import com.aquarium.models.tables.FishDailyFeed;
import com.aquarium.services.FishDailyFeedService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/fdfs")
public class FishDailyFeedController {
    private final FishDailyFeedService fishDailyFeedService;

    @GetMapping("/{id}/aliments")
    public List<FishDailyAlimentDTO> getAliments(@PathVariable Long id) {
        FishDailyFeed fdf = fishDailyFeedService.findById(id);
        return FishDailyAlimentDTO.toDTOList(fdf.getFishDailyAliments());
    }

    @GetMapping("/{id}/nutrients")
    public List<FishDailyNutrientTotalDTO> getNutrients(@PathVariable Long id) {
        FishDailyFeed fdf = fishDailyFeedService.findById(id);
        List<NutrientQtt> nutrientsQtts = fishDailyFeedService.nutrientsQtt(fdf);
        return FishDailyNutrientTotalDTO.toDTOList(nutrientsQtts);
    }
}
