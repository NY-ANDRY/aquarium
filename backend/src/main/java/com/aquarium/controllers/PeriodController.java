package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.PeriodService;
import com.aquarium.mappers.PeriodMapper;
import com.aquarium.dto.PeriodDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/period")
public class PeriodController {
    private final PeriodService service;
    private final PeriodMapper mapper;

    @GetMapping
    public List<PeriodDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PeriodDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
