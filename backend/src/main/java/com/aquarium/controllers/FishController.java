package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import com.aquarium.dto.fish.FishDTO;
import com.aquarium.mappers.FishMapper;
import com.aquarium.models.tables.Fish;
import com.aquarium.services.FishService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/fish")
public class FishController {
    private final FishService fishService;
    private final FishMapper fishMapper;

    @GetMapping("/{id}")
    public FishDTO getOne(@PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Fish f = null;

        if (date != null) {
            f = fishService.findByIdAt(id, date.atStartOfDay());
        } else {
            f = fishService.findById(id);
        }

        return fishMapper.toDTO(f);
    }

    @GetMapping("/{id}/story")
    public FishDTO getOneLog(@PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Fish f = null;

        if (date != null) {
            f = fishService.findByIdAt(id, date.atStartOfDay());
        } else {
            f = fishService.findById(id);
        }

        return fishMapper.toDTO(f);
    }
}
