package co.simplon.gamebotsback.unit.presentation.controllers.game;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.business.service.game.Igameservice;
import co.simplon.gamebotsback.presentation.controller.game.GetAllGameController;
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
class GetAllGameControllerTest {

  @InjectMocks
  private GetAllGameController controller;

  @Mock
  private Igameservice gameService;

  @Test
  void getAllGames() {
    when(gameService.getAll()).thenReturn(List.of(new Gamedto()));
    controller.findAllGames();
    verify(gameService, times(1)).getAll();
  }
}
