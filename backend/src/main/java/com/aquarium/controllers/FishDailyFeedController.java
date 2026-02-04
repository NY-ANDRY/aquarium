package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.FishDailyFeedService;
import com.aquarium.mappers.FishDailyFeedMapper;
import com.aquarium.dto.FishDailyFeedDTO;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/fishdailyfeed")
public class FishDailyFeedController {
    private final FishDailyFeedService service;
    private final FishDailyFeedMapper mapper;

    @GetMapping
    public List<FishDailyFeedDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FishDailyFeedDTO getById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
