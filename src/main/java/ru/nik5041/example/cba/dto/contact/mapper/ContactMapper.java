package ru.nik5041.example.cba.dto.contact.mapper;

import lombok.experimental.UtilityClass;
import ru.nik5041.example.cba.dto.contact.ContactRequestDto;
import ru.nik5041.example.cba.dto.contact.ContactResponseDto;
import ru.nik5041.example.cba.entity.Contact;
import ru.nik5041.example.cba.entity.ContactType;

@UtilityClass
public class ContactMapper {

    public ContactResponseDto toContactResponseDto(Contact contact) {
        return new ContactResponseDto(
                contact.getContactValue()
        );
    }

    public Contact toContact(ContactRequestDto contactRequestDto) {
        return new Contact(
                null,
                null,
                ContactType.fromString(contactRequestDto.contactType()),
                contactRequestDto.contactValue()
        );
    }
}
