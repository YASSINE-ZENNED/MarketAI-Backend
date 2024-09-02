package com.Client;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  @Autowired private ClientRepository clientRepository;

  public ClientEntity saveClient(ClientCreationRequest client) {
    ClientEntity clientEntityToCreate =
        ClientEntity.builder()
            .name(client.name())
            .email(client.email())
            .password(client.password())
            // .address(client.address())
            .phone(client.phone())
            .photo(client.photo())
            .build();

    clientRepository.save(clientEntityToCreate);
    return clientEntityToCreate;
  }

  public boolean isClient(Long id) {
    if (clientRepository.existsById(id)) {
      ClientEntity client = clientRepository.findById(id).orElseThrow();
      if(client.isAccountNonExpired() && client.isAccountNonLocked() && client.isCredentialsNonExpired() && client.isEnabled()) {
        return true;
      }

    }
     return false;
  }


  public ClientEntity getClient(Long id) {
    return clientRepository.findById(id).orElseThrow();
  }

  public Optional<ClientEntity> findByEmail(String email) {
    return clientRepository.findByEmail(email);
  }

  public List<ClientEntity> getAllClients() {
    return clientRepository.findAll();
  }
}
