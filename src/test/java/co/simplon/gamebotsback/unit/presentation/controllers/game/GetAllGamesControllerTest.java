package co.simplon.gamebotsback.unit.presentation.controllers.game;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.business.service.game.Igameservice;
import co.simplon.gamebotsback.presentation.controller.game.GetAllGamesController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllGamesControllerTest {

  @InjectMocks
  private GetAllGamesController controller;

  @Mock
  private Igameservice gameService;

  @Test
  @DisplayName("Test de recuperation de tous les jeux depuis le controller")
  void getAllGames() {
    when(gameService.getAllGames()).thenReturn(List.of(new Gamedto()));
    controller.findAllGames();
    verify(gameService, times(1)).getAllGames();
  }
}
