package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.NutrientService;
import com.aquarium.mappers.NutrientMapper;
import com.aquarium.dto.NutrientDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/nutrients")
public class NutrientController {
    private final NutrientService service;
    private final NutrientMapper mapper;

    @GetMapping
    public List<NutrientDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public NutrientDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
