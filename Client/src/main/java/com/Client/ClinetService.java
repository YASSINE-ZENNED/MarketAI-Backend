package com.Client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinetService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(ClientCreationRequest client) {
        Client clienttoCretae = Client.builder()
                .name(client.name())
                .email(client.email())
                .password(client.password())
                .address(client.address())
                .phone(client.phone())
                .photo(client.photo())

                .build();

        clientRepository.save(clienttoCretae);
        System.out.println("Client saved");

    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
