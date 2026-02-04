package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.AquariumService;
import com.aquarium.mappers.AquariumMapper;
import com.aquarium.dto.AquariumDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/aquariums")
public class AquariumController {
    private final AquariumService service;
    private final AquariumMapper mapper;

    @GetMapping
    public List<AquariumDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AquariumDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
