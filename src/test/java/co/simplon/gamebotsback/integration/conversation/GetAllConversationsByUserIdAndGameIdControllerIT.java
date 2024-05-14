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
import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;

import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.repository.game.Igamerepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-tests.properties")
class GetAllConversationsByUserIdAndGameIdControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Iconversationservice conversationService;

    @Autowired
    private Iuserservice userservice;

    @Autowired
    private Igamerepository gamerepository;

    @BeforeEach
    void setUp() {

        Conversationdto conversation = new Conversationdto();
        conversation.setIdConversation(1);

        Userdto user = new Userdto();
        user.setIdUser(1);
        user.setPassword("password");

        Game game = new Game();
        game.setIdGame(1);

        conversationService.addNewConversation(conversation);
        gamerepository.save(game);
        userservice.createUserAccount(user);
    }

    @Test
    @DisplayName("Test d'intégration de récupération d'une conversation par son jeu et son utilisateur depuis le controller")
    void createConversationIntegrationTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/games/1/conversations")
                .contentType(MediaType.APPLICATION_JSON)
                .with(SecurityMockMvcRequestPostProcessors.jwt()))
                .andExpect(status().isOk());
    }

}
