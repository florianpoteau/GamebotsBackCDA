package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.business.service.game.GameServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.repository.game.IGameRepository;
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
class GameServiceTest {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private IGameRepository iGameRepository;

    @Test
    @DisplayName("Test de récupération de tous les jeux")
    void getAll() {
        when(iGameRepository.findAll()).thenReturn(List.of(new Game()));
        List<GameDTO> games = gameService.getAll();
        verify(iGameRepository, times(1)).findAll();
        assertEquals(GameDTO.class, games.get(0).getClass(), "GameDTO attendu dans la liste");
    }

}
