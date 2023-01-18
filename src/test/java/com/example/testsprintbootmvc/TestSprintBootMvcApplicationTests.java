package com.example.testsprintbootmvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class TestSprintBootMvcApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void assertMockMvcNotNull() {
        assertNotNull(mvc);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void assetCallControllerSuccess() throws Exception {
        // Arrange
        String uri = "/";

        // Act
        var result = mvc.perform(get(uri)
                .accept(MediaType.APPLICATION_JSON))
            .andReturn();
        int statusCode = result.getResponse().getStatus();

        // Assert
        assertEquals(200, statusCode);
        String contentString = result.getResponse().getContentAsString();
        assertTrue(contentString.length() > 4);
        assertEquals("Hey,", contentString.substring(0, 4));
    }
}
