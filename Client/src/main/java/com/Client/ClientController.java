package com.Client;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;



@GetMapping("/isClient")
public boolean isClient(@RequestParam("id") Long id) {
  return clientService.isClient(id);
}

@GetMapping("/")
public List<ClientEntity> hello() {
  return clientService.getAllClients();
}


  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ClientEntity> createClient(@RequestBody ClientCreationRequest request) {
    log.info("Creating client with name: {}", request);
    ClientEntity clientEntity = clientService.saveClient(request);
    return new ResponseEntity<>(clientEntity, HttpStatus.CREATED);
  }


  @KafkaListener(topics = "clientValidationTopic", groupId = "KafkaGroup") // Use your consumer group ID
  public boolean consumeTicketMessage(String clientId) {


//    String[] parts = clientId.split(" "); // Split the string at spaces


//    int SeatsTaken =  Integer.parseInt(parts[0]);
    long ClientId = Long.parseLong(clientId);

    log.info("checking is the client valid with id : {}",ClientId);
    // Process the ticket message to update seats
    return clientService.isClient(ClientId);
  }
}
