package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.business.service.message.MessageServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Message;
import co.simplon.gamebotsback.persistance.repository.message.IMessageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @InjectMocks
    private MessageServiceImpl messageService;

    @Mock
    private IMessageRepository iMessageRepository;

    @Test
    @DisplayName("Test de récupération de tous les messages d'une conversation")
    void testGetAllMessageConversation() {

        when(iMessageRepository.getMessageByConversationId(any(Integer.class))).thenReturn(List.of(new Message()));
        List<MessageDTO> messages = messageService.getAllMessageConversation(any(Integer.class));

        verify(iMessageRepository, times(1)).getMessageByConversationId(any(Integer.class));
        assertEquals(MessageDTO.class, messages.get(0).getClass(), "MessageDTO attendu dans la liste");
    }

    @Test
    @DisplayName("Test d'ajout d'un nouveau message")
    void testAddNewMessage() {

        when(iMessageRepository.save(any(Message.class))).thenReturn(null);
        messageService.addNewMessage(new MessageDTO());

        verify(iMessageRepository, times(1)).save(any(Message.class));
    }
}
