package com.example.testsprintbootmvc;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class MockServiceResource {
    @Bean(name = "mm")
    @Primary
    public MessageService messageService(){
        return mock(MessageService.class);
    }

}
