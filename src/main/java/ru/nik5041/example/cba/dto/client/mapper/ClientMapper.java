package ru.nik5041.example.cba.dto.client.mapper;

import lombok.experimental.UtilityClass;
import ru.nik5041.example.cba.dto.client.ClientRequestDto;
import ru.nik5041.example.cba.dto.client.ClientResponseDto;
import ru.nik5041.example.cba.dto.client.NewClientResponseDto;
import ru.nik5041.example.cba.dto.contact.mapper.ContactMapper;
import ru.nik5041.example.cba.entity.Client;

import java.util.Collections;
import java.util.Optional;


@UtilityClass
public class ClientMapper {

    public Client toClient(ClientRequestDto clientRequestDto) {
        return new Client(
                null,
                clientRequestDto.name(),
                null
        );
    }

    public ClientResponseDto toClientResponseDto(Client client) {
        return new ClientResponseDto(
                client.getId(),
                client.getName(),
                Optional.ofNullable(client.getContacts())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(ContactMapper::toContactResponseDto)
                        .toList()
        );
    }

    public NewClientResponseDto toNewClientResponseDto(Client client) {
        return new NewClientResponseDto(
                client.getId(),
                client.getName()
        );
    }
}
