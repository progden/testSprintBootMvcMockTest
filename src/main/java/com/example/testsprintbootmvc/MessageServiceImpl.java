package com.example.testsprintbootmvc;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    public String getMessage() {
        return "Hey, Spring Boot & Hello world.";
    }
}
