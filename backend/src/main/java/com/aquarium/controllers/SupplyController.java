package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.models.tables.Supply;
import com.aquarium.services.SupplyService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/supplies")
public class SupplyController {
    private final SupplyService service;

    @GetMapping
    public List<Supply> getAll() {
        return service.findAll();
    }
}
