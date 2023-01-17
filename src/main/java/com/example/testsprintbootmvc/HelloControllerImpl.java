package com.example.testsprintbootmvc;public class HelloControllerImpl implements com.example.testsprintbootmvc.HelloController{	public HelloControllerImpl()	{	}@java.lang.Override
    @org.springframework.web.bind.annotation.RequestMapping("/")
    public java.lang.String hello() {
        return "Hey, Spring Boot & Hello world.";
    }}