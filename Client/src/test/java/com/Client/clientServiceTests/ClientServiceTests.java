package com.Client.clientServiceTests;


import com.Client.Client;
import com.Client.ClientCreationRequest;
import com.Client.ClientRepository;
import com.Client.ClinetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClinetService clientService;

    @Test
    public void clientService_saveClient_ReturnSavedClient() {

        ClientCreationRequest clientCreationRequest = ClientCreationRequest.builder()
                .name("testClient")
                .email("test@test.com")
                .password("testPassword")
                .address("testAddress")
                .phone("28895395")
                .photo("testPhoto.png")
                .build();

        Client client = Client.builder()
                .id(1L)
                .name("testClient")
                .email("test@test.com")
                .password("testPassword")
                .address("testAddress")
                .phone("28895395")
                .photo("testPhoto.png")
                .build();

        when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);

        Client savedClient = clientService.saveClient(clientCreationRequest);

        Assertions.assertNotNull(savedClient);


    }

}
