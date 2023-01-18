package com.example.testsprintbootmvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest(classes = TestSprintBootMvcApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
class TestSprintBootMvcApplicationMockTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mvc;

    @Autowired
    @Qualifier("mm")
    private MessageService msgSvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void assertMockMvcNotNull() {
        assertNotNull(mvc);
    }

    @Test
    void givenMockedMsgService_assetCallControllerSuccess() throws Exception {
        // Arrange
        String uri = "/";
        when(msgSvc.getMessage()).thenReturn("Test");

        // Act
        var result = mvc.perform(get(uri)
                .accept(MediaType.APPLICATION_JSON))
            .andReturn();
        int statusCode = result.getResponse().getStatus();

        // Assert
        assertEquals(200, statusCode);
        String contentString = result.getResponse().getContentAsString();
        assertEquals("Test", contentString);
    }
}
