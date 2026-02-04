package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.AlimentService;
import com.aquarium.mappers.AlimentMapper;
import com.aquarium.dto.AlimentDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/aliments")
public class AlimentController {
    private final AlimentService service;
    private final AlimentMapper mapper;

    @GetMapping
    public List<AlimentDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AlimentDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
