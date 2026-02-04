package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.FishService;
import com.aquarium.mappers.FishMapper;
import com.aquarium.dto.FishDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/fish")
public class FishController {
    private final FishService service;
    private final FishMapper mapper;

    @GetMapping
    public List<FishDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FishDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
