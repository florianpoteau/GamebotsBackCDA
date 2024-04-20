package co.simplon.gamebotsback.unit.business.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;

import co.simplon.gamebotsback.business.service.conversation.ConversationServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.repository.conversation.IConversationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

    @ExtendWith(MockitoExtension.class)
    class ConversationServiceTest {

        @InjectMocks
        private ConversationServiceImpl conversationService;

        @Mock
        private IConversationRepository iConversationRepository;

        @Test
        @DisplayName("Test d'ajout d'une nouvelle conversation")
        void addNewConversation() {
            when(iConversationRepository.save(any(Conversation.class))).thenReturn(null);
            conversationService.addNewConversation(new ConversationDTO());
            verify(iConversationRepository, times(1)).save(any(Conversation.class));
        }


        @Test
        @DisplayName("Test de récupération de toutes les conversations d'un utilisateur")
        void getAllUserConversation() {
            when(iConversationRepository.getAllUserConversation(1)).thenReturn(List.of(new Conversation()));
            List<ConversationDTO> conversations = conversationService.getAllUserConversation(1);
            verify(iConversationRepository, times(1)).getAllUserConversation(1);
            assertEquals(ConversationDTO.class, conversations.get(0).getClass());
        }


        @Test
        @DisplayName("Test de récupération de toutes les conversations d'un utilisateur pour un jeu donné")
        void getAllUserConversationByGameId() {
            when(iConversationRepository.getAllUserConversationByGameId(1, 1)).thenReturn(List.of(new Conversation()));
            List<ConversationDTO> conversations = conversationService.getAllUserConversationByGameId(1, 1);
            verify(iConversationRepository, times(1)).getAllUserConversationByGameId(1, 1);
            assertEquals(ConversationDTO.class, conversations.get(0).getClass());
        }
    }
