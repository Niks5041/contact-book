package ru.nik5041.example.cba.dto.contact;

import java.util.List;

public record ClientContactsResponseDto(
        List<ContactResponseDto> contactList
)  {
}
