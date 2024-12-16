package ru.nik5041.example.cba.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nik5041.example.cba.dto.client.ClientRequestDto;
import ru.nik5041.example.cba.dto.client.ClientResponseDto;
import ru.nik5041.example.cba.dto.client.NewClientResponseDto;
import ru.nik5041.example.cba.dto.contact.ClientContactsResponseDto;
import ru.nik5041.example.cba.dto.contact.ContactRequestDto;
import ru.nik5041.example.cba.dto.contact.ContactResponseDto;
import ru.nik5041.example.cba.service.ClientService;


import java.util.List;


@Slf4j
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewClientResponseDto addClient(@RequestBody ClientRequestDto client) {
        log.info("==> POST. Добавление нового клиента: {}", client);
        NewClientResponseDto receivedClient = clientService.addClient(client);
        log.info("<== POST. Добавлен клиент: {}", receivedClient);
        return receivedClient;
    }

    @PostMapping("/{clientId}/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto addContactToClient(@PathVariable Long clientId,
                                                @RequestBody ContactRequestDto contact) {
        log.info("==> POST. Добавление контакта к клиенту с ID: {}", clientId);
        ClientResponseDto receivedClient = clientService.addContactToClient(clientId, contact);
        log.info("<== POST. Добавлен контакт к клиенту с ID: {}", clientId);
        return receivedClient;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponseDto> getAllClients() {
        log.info("==> GET. Получение всех клиентов");
        List<ClientResponseDto> clients = clientService.getAllClients();
        log.info("<== GET. Получен список клиентов: {}", clients);
        return clients;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto getClientById(@PathVariable Long id) {
        log.info("==> GET. Получение клиента по ID: {}", id);
        ClientResponseDto client = clientService.getClientById(id);
        log.info("<== GET. Получен клиент: {}", client);
        return client;
    }

    @GetMapping("/{id}/contacts")
    @ResponseStatus(HttpStatus.OK)
    public ClientContactsResponseDto getContactsByClientId(@PathVariable Long id) {
        log.info("==> GET. Получение контактов клиента по ID: {}", id);
        ClientContactsResponseDto client = clientService.getContactsByClientId(id);
        log.info("<== GET. Получен клиент: {}", client);
        return client;
    }

    @GetMapping("/{clientId}/contacts/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponseDto> getContactsByClientIdAndType(@PathVariable Long clientId,
                                                                 @PathVariable String type) {
        log.info("==> GET. Получение контактов клиента с ID: {} по типу: {}", clientId, type);
        List<ContactResponseDto> contacts = clientService.getContactsByClientIdAndType(clientId, type);
        log.info("<== GET. Получены контакты клиента с ID: {} по типу: {}", clientId, type);
        return contacts;
    }
}
