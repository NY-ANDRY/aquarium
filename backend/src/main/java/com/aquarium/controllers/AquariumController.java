package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import com.aquarium.dto.aquarium.AquariumDTO;
import com.aquarium.dto.aquarium.AquariumFishDTO;
import com.aquarium.models.tables.Aquarium;
import com.aquarium.models.tables.Fish;
import com.aquarium.services.AquariumService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/aquariums")
public class AquariumController {
    private final AquariumService aquariumService;

    @GetMapping("/{id}")
    public AquariumDTO getOne(@PathVariable Long id) {
        Aquarium aquarium = aquariumService.findById(id);
        return AquariumDTO.fromEntity(aquarium);
    }

    @GetMapping("/{id}/fish")
    public List<AquariumFishDTO> getFish(@PathVariable Long id) {
        Aquarium aquarium = aquariumService.findById(id);
        List<Fish> fish = aquarium.getFish();
        return AquariumFishDTO.toDTOList(fish);
    }
}
