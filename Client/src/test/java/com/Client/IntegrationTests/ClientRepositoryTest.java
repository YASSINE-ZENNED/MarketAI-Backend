package com.Client.IntegrationTests;

import com.Client.ClientEntity;
import com.Client.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.junit.jupiter.api.Assertions;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0");

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void isContainerRunning() {
        Assertions.assertTrue(postgres.isRunning());
    }

    @Test
    void testSaveClient() {
        ClientEntity client = new ClientEntity();
        client.setName("Test Client");
        client.setEmail("test@example.com");

        ClientEntity savedClient = clientRepository.save(client);

        Assertions.assertNotNull(savedClient.getId());
        Assertions.assertEquals("Test Client", savedClient.getName());
    }

//    @Test
//    void testFindByEmail() {
//        ClientEntity client = new ClientEntity();
//        client.setName("Test Client");
//        client.setEmail("test@example.com");
//        clientRepository.save(client);
//
//        ClientEntity foundClient = clientRepository.findByEmail("test@example.com");
//        Assertions.assertNotNull(foundClient);
//        Assertions.assertEquals("Test Client", foundClient.getName());
//    }
}