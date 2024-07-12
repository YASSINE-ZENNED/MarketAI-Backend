package com.Client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ClientController {

    @Autowired
    private ClinetService clientService;

    @GetMapping("/GetAllClients")
    public List<Client> hello() {
        return clientService.getAllClients();

    }



    @PostMapping("/CreateClient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createClient(@RequestBody ClientCreationRequest request) {
        log.info("Creating client with name: {}", request);
        Client client = clientService.saveClient(request);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}
