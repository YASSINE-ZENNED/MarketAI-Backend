package com.Client.RepositoryTests;

import com.Client.ClientEntity;
import com.Client.ClientRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ClientEntityRepositoryTests {

  @Autowired private ClientRepository clientRepository;

  @Test
  public void clientRepository_saveClient_ReturnSavedClient() {

    ClientEntity clienttoCretae =
        ClientEntity.builder()
            .name("testClient")
            .email("test@test.com")
            .password("testPassword")
            .address("testAddress")
            .phone("testPhone")
            .photo("testPhoto.png")
            .build();

    ClientEntity savedClientEntity = clientRepository.save(clienttoCretae);
    Assertions.assertNotNull(savedClientEntity);
    Assertions.assertEquals(clienttoCretae.getName(), savedClientEntity.getName());
  }

  @Test
  void clientRepository_GetClientById_ReturnClient() {

    ClientEntity clienttoCretae =
        ClientEntity.builder()
            .id(1L)
            .name("testClient")
            .email("test@test.com")
            .password("testPassword")
            .address("testAddress")
            .phone("testPhone")
            .photo("testPhoto.png")
            .build();

    ClientEntity savedClientEntity = clientRepository.save(clienttoCretae);

    ClientEntity clientEntity = clientRepository.findById(clienttoCretae.getId()).get();

    Assertions.assertNotNull(clientEntity);

    Assertions.assertEquals(clienttoCretae.getName(), clientEntity.getName());

    Assertions.assertEquals(clienttoCretae.getId(), clientEntity.getId());
  }

  @Test
  void clientRepository_getAllClient_ReturnAllClient() {
    ClientEntity clienttoCretae1 =
        ClientEntity.builder()
            .name("testClient1")
            .email("test1@test.com")
            .password("testPassword1")
            .address("testAddress1")
            .phone("testPhone1")
            .photo("testPhoto1.png")
            .build();
    ClientEntity clienttoCretae2 =
        ClientEntity.builder()
            .name("testClient2")
            .email("test2@test.com")
            .password("testPassword2")
            .address("testAddress2")
            .phone("testPhone2")
            .photo("testPhoto2.png")
            .build();
    clientRepository.save(clienttoCretae1);
    clientRepository.save(clienttoCretae2);

    List<ClientEntity> clientEntities = clientRepository.findAll();

    Assertions.assertNotNull(clientEntities);

    Assertions.assertEquals(2, clientEntities.size());
  }

  @Test
  void clientRepository_GetClientByPhone_ReturnClient() {

    ClientEntity clienttoCretae =
        ClientEntity.builder()
            .id(1L)
            .name("testClient")
            .email("test@test.com")
            .password("testPassword")
            .address("testAddress")
            .phone("28895395")
            .photo("testPhoto.png")
            .build();

    ClientEntity savedClientEntity = clientRepository.save(clienttoCretae);

    ClientEntity clientEntity = clientRepository.findByPhone(clienttoCretae.getPhone()).get();

    Assertions.assertNotNull(clientEntity);

    Assertions.assertEquals(clienttoCretae.getName(), clientEntity.getName());

    Assertions.assertEquals(clienttoCretae.getPhone(), clientEntity.getPhone());
  }

  @Test
  void clientRepository_GetClientEmailAndPhoto_ReturnClientEmailandPhoto() {

    ClientEntity clienttoCretae =
        ClientEntity.builder()
            .id(1L)
            .name("testClient")
            .email("test@test.com")
            .password("testPassword")
            .address("testAddress")
            .phone("28895395")
            .photo("testPhoto.png")
            .build();

    ClientEntity savedClientEntity = clientRepository.save(clienttoCretae);

    ClientEntity clientEntity = clientRepository.getClientEmailAndPhoto(1L).get();

    Assertions.assertNotNull(clientEntity);

    Assertions.assertEquals(clienttoCretae.getEmail(), clientEntity.getEmail());

    Assertions.assertEquals(clienttoCretae.getPhoto(), clientEntity.getPhoto());

    System.out.println("___________________________");
    System.out.println(clientEntity);
    System.out.println("___________________________");
  }
}
