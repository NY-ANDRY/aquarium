package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.SpeciesService;
import com.aquarium.mappers.RaceMapper;
import com.aquarium.dto.RaceDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/species")
public class SpeciesController {
    private final SpeciesService service;
    private final RaceMapper mapper;

    @GetMapping
    public List<RaceDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RaceDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
