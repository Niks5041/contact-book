package ru.nik5041.example.cba.service;


import ru.nik5041.example.cba.dto.client.ClientRequestDto;
import ru.nik5041.example.cba.dto.client.ClientResponseDto;
import ru.nik5041.example.cba.dto.client.NewClientResponseDto;
import ru.nik5041.example.cba.dto.contact.ClientContactsResponseDto;
import ru.nik5041.example.cba.dto.contact.ContactRequestDto;
import ru.nik5041.example.cba.dto.contact.ContactResponseDto;

import java.util.List;

public interface ClientService {

    NewClientResponseDto addClient(ClientRequestDto client);

    ClientResponseDto addContactToClient(Long id, ContactRequestDto client);

    List<ClientResponseDto> getAllClients();

    ClientResponseDto getClientById(Long id);

    ClientContactsResponseDto getContactsByClientId(Long id);

    List<ContactResponseDto> getContactsByClientIdAndType(Long id, String type);
}
