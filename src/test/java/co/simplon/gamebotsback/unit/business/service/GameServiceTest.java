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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private IGameRepository iGameRepository;

    Game existingGame = new Game();
    int gameId = 1;

    @Test
    @DisplayName("Test de récupération de tous les jeux")
    void testGetAll() {
        when(iGameRepository.findAll()).thenReturn(List.of(new Game()));
        List<GameDTO> games = gameService.getAll();
        verify(iGameRepository, times(1)).findAll();
        assertEquals(GameDTO.class, games.get(0).getClass(), "GameDTO attendu dans la liste");
    }

        @Test
        @DisplayName("Test de récupération d'un jeu par son id")
        void testGetById() {
            existingGame.setIdGame(gameId);
            when(iGameRepository.findById(gameId)).thenReturn(Optional.of(existingGame));
            GameDTO gameDTO = gameService.getById(gameId);
            verify(iGameRepository, times(1)).findById(gameId);
            assertNotNull(gameDTO, "ImageDTO attendu dans la liste");
            assertEquals(gameId, gameDTO.getIdGame(), "ImageDTO attendu dans la liste");
        }

        @Test
        @DisplayName("Test de récupération d'un jeu par son id - jeu non trouvé")
        void testGetByIdWhenGameDoesNotExist() {
            when(iGameRepository.findById(gameId)).thenReturn(Optional.empty());
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->  gameService.getById(gameId));
            assertEquals("The game with the specified ID does not exist: " + gameId, exception.getMessage(),
                    "Expected exception message to match");
        }
}
