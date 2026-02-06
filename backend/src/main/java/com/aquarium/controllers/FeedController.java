package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.RequiredArgsConstructor;

import com.aquarium.mappers.FishMapper;
import com.aquarium.services.FishDailyFeedService;
import com.aquarium.services.FishService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/feed")
public class FeedController {
    private final FishService fishService;
    private final FishMapper fishMapper;
    private final FishDailyFeedService fishDailyFeedService;

    // @GetMapping("/{id}/nutrients")
    // public FishDTO getOneNutrient(@PathVariable Long id,
    // @RequestParam(required = false) @DateTimeFormat(iso =
    // DateTimeFormat.ISO.DATE) LocalDate date) {
    // Fish f = null;

    // if (date != null) {
    // f = fishService.findByIdAt(id, date.atStartOfDay());
    // } else {
    // f = fishService.findById(id);
    // }

    // return fishMapper.toDTO(f);
    // }

}
