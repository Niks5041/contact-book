package ru.nik5041.example.cba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nik5041.example.cba.entity.Contact;
import ru.nik5041.example.cba.entity.ContactType;

import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClientIdAndContactType(Long clientId, ContactType contactType);
}
