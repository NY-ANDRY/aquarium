package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.models.tables.Flow;
import com.aquarium.services.FlowService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/flows")
public class FlowController {
    private final FlowService service;

    @GetMapping
    public List<Flow> getAll() {
        return service.findAll();
    }
}
