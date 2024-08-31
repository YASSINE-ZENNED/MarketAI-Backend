package com.Client.ClientServiceTests;

import static org.mockito.Mockito.*;

import com.Client.ClientCreationRequest;
import com.Client.ClientEntity;
import com.Client.ClientRepository;
import com.Client.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientServiceTests {

  @Mock private ClientRepository clientRepository;

  @InjectMocks private ClientService clientService;

  @Test
  void testSaveClient_ReturnSavedClient() {

    ClientCreationRequest clientCreationRequest =
        ClientCreationRequest.builder()
            .name("testClient")
            .email("test@test.com")
            .password("testPassword")
            .address("testAddress")
            .phone("28895395")
            .photo("testPhoto.png")
            .build();

    ClientEntity clientEntity =
        ClientEntity.builder()
            .id(1L)
            .name("testClient")
            .email("test@test.com")
            .password("testPassword")
            .address("testAddress")
            .phone("28895395")
            .photo("testPhoto.png")
            .build();

    when(clientRepository.save(Mockito.any(ClientEntity.class))).thenReturn(clientEntity);

    ClientEntity savedClientEntity = clientService.saveClient(clientCreationRequest);

    Assertions.assertNotNull(savedClientEntity);
    Assertions.assertEquals(1L, savedClientEntity.getId());
    Assertions.assertEquals("testClient", savedClientEntity.getName());
  }
}
