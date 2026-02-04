package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

import com.aquarium.models.tables.Period;
import com.aquarium.services.PeriodService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/test")
public class TestController {
    private final PeriodService periodService;

    @GetMapping("")
    public String test() {

        Period p = periodService.findById(1L);
        LocalDateTime end_date = LocalDateTime.parse("2026-01-10T00:00:00");

        periodService.process(p, end_date);
        return "ok";
    }
}
