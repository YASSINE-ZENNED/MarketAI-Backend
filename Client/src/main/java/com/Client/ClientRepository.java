package com.Client;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

  Optional<ClientEntity> findByEmail(String email);

  Optional<ClientEntity> findByPhone(String phone);

  @Query(
          value = "SELECT c.id AS id, c.email AS email, c.photo AS photo FROM client c WHERE c.id = ?1",
          nativeQuery = true)
  Optional<ClientEntity> getClientEmailAndPhoto(Long id);
}