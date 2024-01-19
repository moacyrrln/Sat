package com.sat.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sat.users.dto.UserDTO;
import com.sat.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserService userService;

  private ObjectMapper objectMapper = new ObjectMapper();

  private UserDTO userDTO;

  @BeforeEach
  void setUp() {
    userDTO = new UserDTO("Test User", "test@email.com", 123456789L, 987654321L);
    // Ajuste o userDTO conforme a estrutura do seu UserDTO
  }

  @Test
  void testCreateUser() throws Exception {
    mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userDTO)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value(userDTO.getName()));
  }

  @Test
  void testGetAllUsers() throws Exception {
    userService.createUser(userDTO);
    mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value(userDTO.getName()));
  }

  // Mais testes podem ser adicionados aqui
}
