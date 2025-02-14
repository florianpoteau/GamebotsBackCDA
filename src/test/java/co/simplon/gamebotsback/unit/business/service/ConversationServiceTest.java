package co.simplon.gamebotsback.unit.business.service;

import static co.simplon.gamebotsback.business.service.conversation.ConversationServiceImpl.ERRORMESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.simplon.gamebotsback.business.service.conversation.ConversationServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.conversation.Iconversationrepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConversationServiceTest {

  int conversationId = 1;
  Conversation existingConversation = new Conversation();
  Conversationdto modifiedConversationdto = new Conversationdto();

  @InjectMocks
  private ConversationServiceImpl conversationService;

  @Mock
  private Iconversationrepository iConversationRepository;

  @Test
  @DisplayName("Test d'ajout d'une nouvelle conversation")
  void testAddNewConversation() {

    Conversation savedConversation = new Conversation();
    savedConversation.setIdConversation(conversationId);

    when(iConversationRepository.save(any(Conversation.class))).thenReturn(savedConversation);

    Conversationdto conversationDto = new Conversationdto();
    conversationDto.setCreationDate(new Date());

    Conversationdto savedDto = conversationService.addNewConversation(conversationDto);

    assertNotNull(savedDto, "The saved conversation DTO should not be null");

    assertEquals(conversationId, savedDto.getIdConversation(), "The ID of the saved conversation DTO should match the expected ID");

    verify(iConversationRepository, times(1)).save(any(Conversation.class));
  }

  @Test
  @DisplayName("Test de récupération d'une conversation par son ID")
  void testGetConversationById() {

    existingConversation.setIdConversation(conversationId);

    when(iConversationRepository.findById(conversationId)).thenReturn(Optional.of(existingConversation));
    Conversationdto conversationDTO = conversationService.getConversationByConversationId(conversationId);

    verify(iConversationRepository, times(1)).findById(conversationId);
    assertNotNull(conversationDTO, "La conversation retournée ne doit pas être nulle");
    assertEquals(conversationId, conversationDTO.getIdConversation(),
        "L'ID de la conversation retournée doit être celui attendu");
  }

  @Test
  @DisplayName("Test de récupération d'une conversation par son ID - conversation non trouvée")
  void testGetConversationByIdNotFound() {

    when(iConversationRepository.findById(conversationId)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
        () -> conversationService.getConversationByConversationId(conversationId));

    verify(iConversationRepository, times(1)).findById(conversationId);
    assertEquals(ERRORMESSAGE + conversationId, exception.getMessage(), "Le message d'erreur doit être correct");
  }

  @Test
  @DisplayName("Test de modification d'une conversation existante")
  void testModifyConversation() {

    existingConversation.setIdConversation(conversationId);
    modifiedConversationdto.setIdConversation(conversationId);
    modifiedConversationdto.setName("Modified Conversation");
    modifiedConversationdto.setModificationDate(new Date());
    modifiedConversationdto.setUser(new User());
    modifiedConversationdto.setGame(new Game());

    when(iConversationRepository.findById(conversationId)).thenReturn(Optional.of(existingConversation));

    conversationService.modifyConversation(conversationId, modifiedConversationdto);

    verify(iConversationRepository, times(1)).findById(conversationId);
    verify(iConversationRepository, times(1)).save(any(Conversation.class));
  }

  @Test
  @DisplayName("Test de modification d'une conversation existante - conversation non trouvée")
  void testModifyConversationNotFound() {

    modifiedConversationdto.setIdConversation(conversationId);
    modifiedConversationdto.setName("Modified Conversation");
    modifiedConversationdto.setModificationDate(new Date());
    modifiedConversationdto.setUser(new User());
    modifiedConversationdto.setGame(new Game());

    when(iConversationRepository.findById(conversationId)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
        () -> conversationService.modifyConversation(conversationId, modifiedConversationdto));

    assertEquals(ERRORMESSAGE + conversationId, exception.getMessage(), "Le message d'erreur doit être correct");
    verify(iConversationRepository, times(1)).findById(conversationId);
    verify(iConversationRepository, never()).save(any(Conversation.class));
  }

  @Test
  @DisplayName("Test de suppression d'une conversation par son ID")
  void testDeleteConversation() {

    existingConversation.setIdConversation(conversationId);

    when(iConversationRepository.findById(conversationId)).thenReturn(Optional.of(existingConversation));
    conversationService.deleteConversation(conversationId);

    verify(iConversationRepository, times(1)).findById(conversationId);
    verify(iConversationRepository, times(1)).deleteById(any(Integer.class));
  }

  @Test
  @DisplayName("Test de suppression d'une conversation par son ID - conversation non trouvée")
  void testDeleteConversationNotFound() {

    when(iConversationRepository.findById(conversationId)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
        () -> conversationService.deleteConversation(conversationId));

    assertEquals(ERRORMESSAGE + conversationId, exception.getMessage(), "Le message d'erreur doit être correct");
    verify(iConversationRepository, times(1)).findById(conversationId);
    verify(iConversationRepository, never()).deleteById(any(Integer.class));
  }

  @Test
  @DisplayName("Test de récupération de toutes les conversations d'un utilisateur")
  void testGetAllUserConversation() {

    when(iConversationRepository.getAllUserConversation(conversationId)).thenReturn(List.of(new Conversation()));
    List<Conversationdto> conversations = conversationService.getAllUserConversations(1);

    verify(iConversationRepository, times(1)).getAllUserConversation(1);
    assertEquals(Conversationdto.class, conversations.get(0).getClass(),
        "La classe de l'objet de conversation ne correspond pas à la classe attendue");
  }

  @Test
  @DisplayName("Test de récupération de toutes les conversations d'un utilisateur pour un jeu donné")
  void testGetAllUserConversationByGameId() {

    when(iConversationRepository.getAllUserConversationByGameId(1, 1)).thenReturn(List.of(new Conversation()));
    List<Conversationdto> conversations = conversationService.getAllUserConversationsByGameId(1, 1);

    verify(iConversationRepository, times(1)).getAllUserConversationByGameId(1, 1);
    assertEquals(Conversationdto.class, conversations.get(0).getClass(),
        "La classe de l'objet de conversation ne correspond pas à la classe attendue");
  }
}
