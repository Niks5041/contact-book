package ru.nik5041.example.cba.dto.client;

import jakarta.validation.constraints.NotNull;

public record ClientRequestDto(
        @NotNull
        String name
) {
}
