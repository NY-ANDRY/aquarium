package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.SupplyService;
import com.aquarium.mappers.SupplyMapper;
import com.aquarium.dto.SupplyDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/supplies")
public class SupplyController {
    private final SupplyService service;
    private final SupplyMapper mapper;

    @GetMapping
    public List<SupplyDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SupplyDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
