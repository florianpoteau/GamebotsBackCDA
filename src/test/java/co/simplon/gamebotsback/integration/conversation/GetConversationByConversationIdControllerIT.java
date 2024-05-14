package co.simplon.gamebotsback.integration.conversation;

import org.junit.jupiter.api.BeforeEach;
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

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-tests.properties")
class GetConversationByConversationIdControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private Iconversationservice conversationService;

  @BeforeEach
  void setUp() {

    Conversationdto conversationDto = new Conversationdto();
    conversationDto.setIdConversation(1);

    conversationService.addNewConversation(conversationDto);
  }

  @Test
  @DisplayName("Test d'intégration de récupération d'une conversation par son id depuis le controller")
  void getConversationByConversationIdIntegrationTest() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/conversations/1")
            .contentType(MediaType.APPLICATION_JSON)
            .with(SecurityMockMvcRequestPostProcessors.jwt()))
        .andExpect(status().isOk());
  }
}
