package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.models.tables.Aliment;
import com.aquarium.services.AlimentService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/aliments")
public class AlimentController {
    private final AlimentService service;

    @GetMapping
    public List<Aliment> getAll() {
        return service.findAll();
    }

}
