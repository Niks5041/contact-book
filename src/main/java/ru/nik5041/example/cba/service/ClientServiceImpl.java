package ru.nik5041.example.cba.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nik5041.example.cba.dto.client.ClientRequestDto;
import ru.nik5041.example.cba.dto.client.ClientResponseDto;
import ru.nik5041.example.cba.dto.client.NewClientResponseDto;
import ru.nik5041.example.cba.dto.client.mapper.ClientMapper;
import ru.nik5041.example.cba.dto.contact.ClientContactsResponseDto;
import ru.nik5041.example.cba.dto.contact.ContactRequestDto;
import ru.nik5041.example.cba.dto.contact.ContactResponseDto;
import ru.nik5041.example.cba.dto.contact.mapper.ContactMapper;
import ru.nik5041.example.cba.entity.Client;
import ru.nik5041.example.cba.entity.Contact;
import ru.nik5041.example.cba.entity.ContactType;
import ru.nik5041.example.cba.repository.ClientRepository;
import ru.nik5041.example.cba.repository.ContactRepository;


import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;


    @Override
    @Transactional
    public NewClientResponseDto addClient(ClientRequestDto client) {
        Client clientEntity = ClientMapper.toClient(client);
        Client savedClient = clientRepository.save(clientEntity);
        return ClientMapper.toNewClientResponseDto(savedClient);
    }

    @Override
    @Transactional
    public ClientResponseDto addContactToClient(Long clientId, ContactRequestDto contactRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Contact contact = ContactMapper.toContact(contactRequest);
        contact.setClient(client);

        Contact savedContact = contactRepository.save(contact);
        client.getContacts().add(savedContact);
        clientRepository.save(client);

        return ClientMapper.toClientResponseDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper::toClientResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toClientResponseDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientContactsResponseDto getContactsByClientId(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        List<ContactResponseDto> contactDtos = client.getContacts().stream()
                .map(ContactMapper::toContactResponseDto)
                .toList();
        return new ClientContactsResponseDto(contactDtos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactResponseDto> getContactsByClientIdAndType(Long clientId, String type) {
        clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        List<Contact> contacts = contactRepository.findByClientIdAndContactType(clientId, ContactType.fromString(type));
        return contacts.stream()
                .map(ContactMapper::toContactResponseDto)
                .toList();
    }
}


