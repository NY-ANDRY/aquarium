package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.FlowService;
import com.aquarium.mappers.FlowMapper;
import com.aquarium.dto.FlowDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/flow")
public class FlowController {
    private final FlowService service;
    private final FlowMapper mapper;

    @GetMapping
    public List<FlowDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FlowDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
