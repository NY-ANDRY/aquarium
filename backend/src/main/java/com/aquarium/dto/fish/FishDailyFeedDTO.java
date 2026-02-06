package com.aquarium.dto.fish;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FishDailyFeedDTO(
                Long id_fdf,
                LocalDateTime date,
                BigDecimal weight,
                BigDecimal increase) {

        public static FishDailyFeedDTO fromEntity(com.aquarium.models.tables.FishDailyFeed fdf) {
                if (fdf == null) {
                        return null;
                }
                return new FishDailyFeedDTO(fdf.getId(), fdf.getDate(), fdf.getCurWeight(), fdf.getIncreaseWeight());
        }

        public static List<FishDailyFeedDTO> toDTOList(List<com.aquarium.models.tables.FishDailyFeed> fdfs) {
                if (fdfs == null) {
                        return List.of();
                }
                return fdfs.stream().map(FishDailyFeedDTO::fromEntity).toList();
        }
}
