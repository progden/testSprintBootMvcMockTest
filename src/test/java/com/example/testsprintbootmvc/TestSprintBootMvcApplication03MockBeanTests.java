package com.example.testsprintbootmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest(classes = TestSprintBootMvcApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
@AutoConfigureMockMvc
class TestSprintBootMvcApplication03MockBeanTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    private MessageService msgSvc;

    @Test
    void assertMockMvcNotNull() {
        assertNotNull(mvc);
    }

    @Test
    void givenMockedMsgService_assetCallControllerSuccess() throws Exception {
        // Controller -> mock Service
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
