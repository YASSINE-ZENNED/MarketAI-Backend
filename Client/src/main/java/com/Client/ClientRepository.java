package com.Client;

import jakarta.persistence.Converter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {


    Optional<Client> findByPhone(String phone);

    @Query(value = "SELECT c.id AS id, c.email AS email, c.photo AS photo FROM client c WHERE c.id = ?1", nativeQuery = true)

    Optional<Client> GetClientEmailAndPhoto(Long id);


}
