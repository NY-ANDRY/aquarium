package com.aquarium.dto.fish;

import java.util.List;

public record FishLogDTO(
        Long id,
        String name,
        List<FishLogDetailDTO> logs) {
}
