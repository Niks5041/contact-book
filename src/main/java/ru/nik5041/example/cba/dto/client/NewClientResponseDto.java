package ru.nik5041.example.cba.dto.client;

import ru.nik5041.example.cba.dto.contact.ContactResponseDto;

import java.util.List;

public record NewClientResponseDto(
        Long id,
        String name
) {
}
