package ru.nik5041.example.cba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nik5041.example.cba.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
