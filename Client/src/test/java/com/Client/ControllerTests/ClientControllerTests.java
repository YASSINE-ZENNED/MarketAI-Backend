package com.Client.ControllerTests;

import com.Client.*;
import com.Client.ClientController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ClientControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClientRepository clientRepository;

    @MockBean
    private ClinetService clientService;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void ClientController_createClient_returnCreated() throws Exception {
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

        given(clientService.saveClient(ArgumentMatchers.any())).willReturn(client);

        ResultActions response = mockMvc.perform(post("/CreateClient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clientCreationRequest)));

        response.andExpect(status().isCreated());
    }
}
