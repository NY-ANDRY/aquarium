package com.aquarium.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarium.models.tables.Color;
import com.aquarium.repositories.ColorRepository;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public ColorService() {
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    public Color getColor(Long idColor) {
        return colorRepository.findById(idColor).orElse(null);
    }

    public Color updateColor(Color color) {
        return colorRepository.save(color);
    }

    public void deleteColor(Long idColor) {
        colorRepository.deleteById(idColor);
    }
}
