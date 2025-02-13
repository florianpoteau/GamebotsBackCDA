package co.simplon.gamebotsback.integration.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-tests.properties")
class GetAllConversationsByUserIdControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private Iconversationservice conversationService;

  @Autowired
  private Iuserservice userService;

  @BeforeEach
  void setUp() {

    Conversationdto conversationDto = new Conversationdto();
    conversationDto.setIdConversation(1);

    Userdto userDto = new Userdto();
    userDto.setIdUser(1);
    userDto.setPassword("password");

    userService.createUserAccount(userDto);
    conversationService.addNewConversation(conversationDto);
  }

  @Test
  @DisplayName("Test d'intégration de récupération de toutes les conversations d'un utilisateur depuis le controller")
  void getAllConversationsByUserId() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/users/1/conversations")
            .contentType(MediaType.APPLICATION_JSON)
            .with(SecurityMockMvcRequestPostProcessors.jwt()))
        .andExpect(status().isOk());
  }
}
