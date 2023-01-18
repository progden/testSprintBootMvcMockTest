package com.example.testsprintbootmvc;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloControllerImpl implements HelloController {
    private MessageService msgService;

    @RequestMapping("/")
    public String hello() {
        return msgService.getMessage();
    }

}