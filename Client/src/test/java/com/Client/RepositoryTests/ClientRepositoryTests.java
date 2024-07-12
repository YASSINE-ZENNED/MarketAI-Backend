package com.Client.RepositoryTests;

import com.Client.Client;
import com.Client.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

class ClientRepositoryTests {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void clientRepository_saveClient_ReturnSavedClient() {

        Client clienttoCretae = Client.builder()
                .name("testClient")
                .email("test@test.com")
                .password("testPassword")
                .address("testAddress")
                .phone("testPhone")
                .photo("testPhoto.png")
                .build();

        Client savedClient = clientRepository.save(clienttoCretae);
        Assertions.assertNotNull(savedClient);
        Assertions.assertEquals(clienttoCretae.getName(), savedClient.getName());


    }



    @Test
    void clientRepository_GetClientById_ReturnClient() {

        Client clienttoCretae = Client.builder()
                .id(1L)
                .name("testClient")
                .email("test@test.com")
                .password("testPassword")
                .address("testAddress")
                .phone("testPhone")
                .photo("testPhoto.png")
                .build();

        Client savedClient = clientRepository.save(clienttoCretae);

        Client client = clientRepository.findById(clienttoCretae.getId()).get();

        Assertions.assertNotNull(client);

        Assertions.assertEquals(clienttoCretae.getName(), client.getName());

        Assertions.assertEquals(clienttoCretae.getId(), client.getId());

    }

    @Test
    void clientRepository_getAllClient_ReturnAllClient() {
        Client clienttoCretae1 = Client.builder()
                .name("testClient1")
                .email("test1@test.com")
                .password("testPassword1")
                .address("testAddress1")
                .phone("testPhone1")
                .photo("testPhoto1.png")
                .build();
        Client clienttoCretae2 = Client.builder()
                .name("testClient2")
                .email("test2@test.com")
                .password("testPassword2")
                .address("testAddress2")
                .phone("testPhone2")
                .photo("testPhoto2.png")
                .build();
        clientRepository.save(clienttoCretae1);
        clientRepository.save(clienttoCretae2);

        List<Client> clients = clientRepository.findAll();


        Assertions.assertNotNull(clients);

        Assertions.assertEquals(2, clients.size());


    }

    @Test
    void clientRepository_GetClientByPhone_ReturnClient() {

        Client clienttoCretae = Client.builder()
                .id(1L)
                .name("testClient")
                .email("test@test.com")
                .password("testPassword")
                .address("testAddress")
                .phone("28895395")
                .photo("testPhoto.png")
                .build();

        Client savedClient = clientRepository.save(clienttoCretae);

        Client client = clientRepository.findByPhone(clienttoCretae.getPhone()).get();

        Assertions.assertNotNull(client);

        Assertions.assertEquals(clienttoCretae.getName(), client.getName());

        Assertions.assertEquals(clienttoCretae.getPhone(), client.getPhone());

    }
    @Test
    void clientRepository_GetClientEmailAndPhoto_ReturnClientEmailandPhoto() {



        Client clienttoCretae = Client.builder()
                .id(1L)
                .name("testClient")
                .email("test@test.com")
                .password("testPassword")
                .address("testAddress")
                .phone("28895395")
                .photo("testPhoto.png")
                .build();

        Client savedClient = clientRepository.save(clienttoCretae);

        Client client = clientRepository.GetClientEmailAndPhoto(1L).get();

        Assertions.assertNotNull(client);

        Assertions.assertEquals(clienttoCretae.getEmail(), client.getEmail());

        Assertions.assertEquals(clienttoCretae.getPhoto(), client.getPhoto());

        System.out.println("___________________________");
        System.out.println(client);
        System.out.println("___________________________");


    }



}