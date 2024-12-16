package ru.nik5041.example.cba.dto.contact;

import jakarta.validation.constraints.NotNull;

public record ContactRequestDto(
       @NotNull
       String contactType,
       @NotNull
       String contactValue
) {
}
