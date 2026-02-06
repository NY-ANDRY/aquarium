package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.aquarium.dto.fish.FishDailyNutrientDTO;
import com.aquarium.mappers.FishMapper;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.services.FishDailyAlimentService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/fdas")
public class FishDailyAlimentController {
    private final FishDailyAlimentService fishDailyAlimentService;
    private final FishMapper fishMapper;

    @GetMapping("/{id}/nutrients")
    public List<FishDailyNutrientDTO> getNutrients(@PathVariable Long id) {
        FishDailyAliment fda = fishDailyAlimentService.findById(id);
        return fishMapper.toNutrientDTOs(fda.getFishDailyNutrient());
    }
}
