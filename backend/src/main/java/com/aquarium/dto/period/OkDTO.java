package com.aquarium.dto.period;

public record OkDTO(Boolean ok, int id) {

    public static OkDTO of(int id) {
        return new OkDTO(true, id);
    }

    public static OkDTO error(int id) {
        return new OkDTO(false, id);
    }
}
