package co.simplon.gamebotsback.integration.conversation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.simplon.gamebotsback.business.dto.Conversationdto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-tests.properties")
class CreateConversationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test d'intégration de création d'une conversation depuis le controller")
    void createConversationIntegrationTest() throws Exception {

        Conversationdto conversationdto = new Conversationdto();
        conversationdto.setName("Comment tuer un zombie");

        String conversationJson = objectMapper.writeValueAsString(conversationdto);

        mockMvc.perform(MockMvcRequestBuilders.post("/conversations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(conversationJson)
                .with(SecurityMockMvcRequestPostProcessors.jwt())
                .with(SecurityMockMvcRequestPostProcessors.csrf().asHeader()))
                .andExpect(status().isOk());
    }
}
