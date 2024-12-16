package ru.nik5041.example.cba.dto.client;


import ru.nik5041.example.cba.dto.contact.ContactResponseDto;

import java.util.List;

public record ClientResponseDto(
        Long id,
        String name,
        List<ContactResponseDto> contactList
) {
}
