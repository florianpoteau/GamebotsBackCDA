package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversationConvertTest {

  private static final ConversationConvert conversationConvert = ConversationConvert.getInstance();

  private static final String name = "Comment tuer des mangeurs d'hommes ?";

  private Conversation createSampleConversation() {

    Conversation conversation = new Conversation();

    conversation.setIdConversation(1);
    conversation.setName(name);
    conversation.setCreationDate(new Date());
    conversation.setModificationDate(new Date());
    conversation.setGame(new Game());
    conversation.setUser(new User());

    return conversation;
  }

  private Conversation createSampleConversationWithNull() {

    Conversation conversation = new Conversation();

    conversation.setIdConversation(1);
    conversation.setName(null);
    conversation.setCreationDate(null);
    conversation.setModificationDate(null);
    conversation.setGame(null);
    conversation.setUser(null);

    return conversation;
  }

  private Conversationdto createSampleConversationDTO() {

    Conversationdto conversationDTO = new Conversationdto();

    conversationDTO.setIdConversation(1);
    conversationDTO.setName(name);
    conversationDTO.setCreationDate(new Date());
    conversationDTO.setModificationDate(new Date());
    conversationDTO.setGame(new Game());
    conversationDTO.setUser(new User());

    return conversationDTO;
  }

  private Conversationdto createSampleConversationDTOWithNull() {

    Conversationdto conversationDTO = new Conversationdto();

    conversationDTO.setIdConversation(1);
    conversationDTO.setName(null);
    conversationDTO.setCreationDate(null);
    conversationDTO.setModificationDate(null);
    conversationDTO.setGame(null);
    conversationDTO.setUser(null);

    return conversationDTO;
  }

  @Test
  @DisplayName("Test de récupération de l'instance de ConversationConvert")
  void testGetInstanceReturnsInstanceOfConversationConvert() {

    ConversationConvert conversationConvert = ConversationConvert.getInstance();

    assertNotNull(conversationConvert);
    assertInstanceOf(ConversationConvert.class, conversationConvert);
  }

  @Test
  @DisplayName("Test de conversion de Conversation à ConversationDto")
  void testConvertConversationToConversationDto() {

    Conversation conversation = createSampleConversation();
    Conversationdto conversationDTO = conversationConvert.convertEntityToDto(conversation);

    assertEquals(1, conversationDTO.getIdConversation());
    assertEquals(name, conversationDTO.getName());
    assertEquals(conversation.getCreationDate(), conversationDTO.getCreationDate());
    assertEquals(conversation.getModificationDate(), conversationDTO.getModificationDate());
    assertEquals(conversation.getGame(), conversationDTO.getGame());
    assertEquals(conversation.getUser(), conversationDTO.getUser());
  }

  @Test
  @DisplayName("Test de conversion de Conversation à ConversationDto quand Conversation est null")
  void testConvertConversationToConversationDtoWithNull() {

    Conversation conversation = createSampleConversationWithNull();
    Conversationdto conversationDTO = conversationConvert.convertEntityToDto(conversation);

    assertEquals(1, conversationDTO.getIdConversation());
    assertNull(conversationDTO.getName());
    assertNull(conversationDTO.getCreationDate());
    assertNull(conversationDTO.getModificationDate());
    assertNull(conversationDTO.getGame());
    assertNull(conversationDTO.getUser());
  }

  @Test
  @DisplayName("Test de conversion de ConversationDto à Conversation")
  void testConvertConversationDtoToConversation() {

    Conversationdto conversationDTO = createSampleConversationDTO();
    Conversation conversation = conversationConvert.convertDtoToEntity(conversationDTO);

    assertEquals(1, conversation.getIdConversation());
    assertEquals(name, conversation.getName());
    assertEquals(conversationDTO.getCreationDate(), conversation.getCreationDate());
    assertEquals(conversationDTO.getModificationDate(), conversation.getModificationDate());
    assertEquals(conversationDTO.getGame(), conversation.getGame());
    assertEquals(conversationDTO.getUser(), conversation.getUser());
  }

  @Test
  @DisplayName("Test de conversion de ConversationDto à Conversation quand ConversationDto est null")
  void testConvertConversationDtoToConversationWithNull() {

    Conversationdto conversationDTO = createSampleConversationDTOWithNull();
    Conversation conversation = conversationConvert.convertDtoToEntity(conversationDTO);

    assertEquals(1, conversation.getIdConversation());
    assertNull(conversation.getName());
    assertNull(conversation.getCreationDate());
    assertNull(conversation.getModificationDate());
    assertNull(conversation.getGame());
    assertNull(conversation.getUser());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de Conversation à une liste de ConversationDto")
  void testConvertListConversationToListConversationDto() {

    List<Conversation> conversationList = List.of(createSampleConversation(), createSampleConversation());
    List<Conversationdto> conversationdtoList = conversationConvert.convertListEntityToListDto(conversationList);

    assertEquals(Conversationdto.class, conversationdtoList.get(0).getClass());
    assertEquals(1, conversationdtoList.get(0).getIdConversation());
    assertEquals(1, conversationdtoList.get(1).getIdConversation());
    assertEquals(name, conversationdtoList.get(0).getName());
    assertEquals(name, conversationdtoList.get(1).getName());
    assertEquals(conversationList.get(0).getCreationDate(), conversationdtoList.get(0).getCreationDate());
    assertEquals(conversationList.get(1).getCreationDate(), conversationdtoList.get(1).getCreationDate());
    assertEquals(conversationList.get(0).getModificationDate(), conversationdtoList.get(0).getModificationDate());
    assertEquals(conversationList.get(1).getModificationDate(), conversationdtoList.get(1).getModificationDate());
    assertEquals(conversationList.get(0).getGame(), conversationdtoList.get(0).getGame());
    assertEquals(conversationList.get(1).getGame(), conversationdtoList.get(1).getGame());
    assertEquals(conversationList.get(0).getUser(), conversationdtoList.get(0).getUser());
    assertEquals(conversationList.get(1).getUser(), conversationdtoList.get(1).getUser());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de Conversation à une liste de ConversationDto quand la liste de Conversation est null")
  void testConvertListConversationToListConversationDtoWithNull() {

    List<Conversation> conversationList = List.of(createSampleConversationWithNull(), createSampleConversationWithNull());
    List<Conversationdto> conversationdtoList = conversationConvert.convertListEntityToListDto(conversationList);

    assertEquals(Conversationdto.class, conversationdtoList.get(0).getClass());
    assertEquals(1, conversationdtoList.get(0).getIdConversation());
    assertEquals(1, conversationdtoList.get(1).getIdConversation());
    assertNull(conversationdtoList.get(0).getName());
    assertNull(conversationdtoList.get(1).getName());
    assertNull(conversationList.get(0).getCreationDate());
    assertNull(conversationList.get(1).getCreationDate());
    assertNull(conversationList.get(0).getModificationDate());
    assertNull(conversationList.get(1).getModificationDate());
    assertNull(conversationList.get(0).getGame());
    assertNull(conversationList.get(1).getGame());
    assertNull(conversationList.get(0).getUser());
    assertNull(conversationList.get(1).getUser());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de ConversationDto à une liste de Conversation")
  void testConvertListConversationDtoToListConversation() {

    List<Conversationdto> conversationdtoList = List.of(createSampleConversationDTO(), createSampleConversationDTO());

    List<Conversation> conversationList = conversationConvert.convertListDtoToListEntity(conversationdtoList);

    assertEquals(Conversation.class, conversationList.get(0).getClass());
    assertEquals(1, conversationList.get(0).getIdConversation());
    assertEquals(1, conversationList.get(1).getIdConversation());
    assertEquals(name, conversationList.get(0).getName());
    assertEquals(name, conversationList.get(1).getName());
    assertEquals(conversationdtoList.get(0).getCreationDate(), conversationList.get(0).getCreationDate());
    assertEquals(conversationdtoList.get(1).getCreationDate(), conversationList.get(1).getCreationDate());
    assertEquals(conversationdtoList.get(0).getModificationDate(), conversationList.get(0).getModificationDate());
    assertEquals(conversationdtoList.get(1).getModificationDate(), conversationList.get(1).getModificationDate());
    assertEquals(conversationdtoList.get(0).getGame(), conversationList.get(0).getGame());
    assertEquals(conversationdtoList.get(1).getGame(), conversationList.get(1).getGame());
    assertEquals(conversationdtoList.get(0).getUser(), conversationList.get(0).getUser());
    assertEquals(conversationdtoList.get(1).getUser(), conversationList.get(1).getUser());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de ConversationDto à une liste de Conversation quand la liste de ConversationDto est null")
  void testConvertListConversationDtoToListConversationWithNull() {

    List<Conversationdto> conversationdtoList = List.of(createSampleConversationDTOWithNull(), createSampleConversationDTOWithNull());
    List<Conversation> conversationList = conversationConvert.convertListDtoToListEntity(conversationdtoList);

    assertEquals(Conversation.class, conversationList.get(0).getClass());
    assertEquals(1, conversationList.get(0).getIdConversation());
    assertEquals(1, conversationList.get(1).getIdConversation());
    assertNull(conversationList.get(0).getName());
    assertNull(conversationList.get(1).getName());
    assertNull(conversationdtoList.get(0).getCreationDate());
    assertNull(conversationdtoList.get(1).getCreationDate());
    assertNull(conversationdtoList.get(0).getModificationDate());
    assertNull(conversationdtoList.get(1).getModificationDate());
    assertNull(conversationdtoList.get(0).getGame());
    assertNull(conversationdtoList.get(1).getGame());
    assertNull(conversationdtoList.get(0).getUser());
    assertNull(conversationdtoList.get(1).getUser());
  }
}
