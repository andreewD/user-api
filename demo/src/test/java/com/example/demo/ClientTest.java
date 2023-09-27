package com.example.demo;

import com.example.demo.models.Client;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientTest {
    private final UserRepository userRepository = mock(UserRepository.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void createClient() {
    Client client = Client.builder()
        .name("John")
        .age(23)
        .email("jhon@jhon.com")
        .build();

    when(userRepository.save(client)).thenReturn(client);
    Client clientSaved = userRepository.save(client);

    assertTrue(clientSaved.getName().equals("John"));
    assertTrue(clientSaved.getAge().equals(23));
    assertTrue(clientSaved.getEmail().equals("jhon@jhon.com"));

    }

    @Test
    public void updateClient() {
        Client client = Client.builder()
                .name("John")
                .age(23)
                .email("jhon@jhon.com")
                .build();

        userRepository.save(client);

        client.setAge(24);

        when(userRepository.save(client)).thenReturn(client);
        Client clientUpdated = userRepository.save(client);

        assertTrue(clientUpdated.getAge().equals(24));

    }

    @Test
    public void deleteClient() {
        Client client = Client.builder()
                .name("John")
                .age(23)
                .email("jhon@jhon.com")
                .build();

        userRepository.save(client);

        when(userRepository.existsById(client.getId())).thenReturn(false);
        boolean exists = userRepository.existsById(client.getId());

        assertTrue(!exists);
    }

    @Test
    public void findByIdClient() {
        Client client = Client.builder()
                .id(1)
                .name("John")
                .age(23)
                .email("jhon@jhon.com").build();

        when(userRepository.findById(client.getId())).thenReturn(java.util.Optional.of(client));

        Client clientFound = userRepository.findById(client.getId()).orElse(null);

        assertTrue(clientFound.getName().equals("John"));

    }

}
