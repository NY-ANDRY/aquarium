package com.aquarium.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aquarium.dto.fish.FishDailyAlimentDTO;
import com.aquarium.dto.fish.FishDTO;
import com.aquarium.dto.fish.FishDailyFeedDTO;
import com.aquarium.dto.fish.FishDailyNutrientDTO;
import com.aquarium.dto.fish.FishDailyNutrientTotalDTO;
import com.aquarium.dto.fish.FishSpeciesDTO;
import com.aquarium.models.logics.NutrientQtt;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyFeed;
import com.aquarium.models.tables.FishDailyNutrient;

@Component
public class FishMapper {

    public FishDTO toDTO(Fish fish) {
        return new FishDTO(fish.getId(), fish.getName(), fish.getCurDatetime(), fish.getCurWeight(),
                fish.getInitialWeight());
    }

    public Fish toEntity(FishDTO dto) {
        Fish fish = new Fish();
        fish.setId(dto.id());
        fish.setName(dto.name());
        return fish;
    }

    public List<FishDTO> toDTOList(List<Fish> aquariums) {
        return aquariums.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public FishDailyFeedDTO logToDTO(FishDailyFeed fdf) {
        return new FishDailyFeedDTO(fdf.getId(), fdf.getDate(), fdf.getCurWeight(), fdf.getIncreaseWeight());
    }

    public List<FishDailyFeedDTO> dailyFeedsToDTO(List<FishDailyFeed> fdfs) {
        return fdfs.stream()
                .map(this::logToDTO)
                .collect(Collectors.toList());
    }

    public FishDailyAlimentDTO toDailyAlimentDTO(FishDailyAliment fda) {
        return new FishDailyAlimentDTO(fda.getId(), fda.getAliment().getId(), fda.getAliment().getName(), fda.getQtt(),
                toNutrientDTOs(fda.getFishDailyNutrient()));
    }

    public List<FishDailyAlimentDTO> toAlimentDTOs(List<FishDailyAliment> fdas) {
        return fdas.stream().map(el -> toDailyAlimentDTO(el)).toList();
    }

    public FishDailyNutrientDTO toDailyNutrientDTO(FishDailyNutrient fdn) {
        return new FishDailyNutrientDTO(fdn.getId(), fdn.getNutrient().getId(), fdn.getNutrient().getName(),
                fdn.getQtt());
    }

    public List<FishDailyNutrientDTO> toNutrientDTOs(List<FishDailyNutrient> fdns) {
        return fdns.stream().map(el -> toDailyNutrientDTO(el)).toList();
    }

    public FishDailyNutrientTotalDTO toNutrientQttDTO(NutrientQtt nq) {
        return new FishDailyNutrientTotalDTO(null, nq.getNutrient().getId(), nq.getNutrient().getName(),
                nq.getQtt(), nq.getCur(), nq.getRest(), nq.getRaceNeed(), nq.getSubNb(), nq.getSubWeight(),
                nq.getWeightInc());
    }

    public List<FishDailyNutrientTotalDTO> toNutrientQttDTOs(List<NutrientQtt> fdns) {
        return fdns.stream().map(el -> toNutrientQttDTO(el)).toList();
    }

    // public FishSpeciesDTO toFishRaceDTO(Species species) {
    // return spe
    // }

}
