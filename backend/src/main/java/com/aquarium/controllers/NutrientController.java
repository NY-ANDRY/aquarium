package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.models.tables.Nutrient;
import com.aquarium.services.NutrientService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/nutrients")
public class NutrientController {
    private final NutrientService service;

    @GetMapping
    public List<Nutrient> getAll() {
        return service.findAll();
    }
}
