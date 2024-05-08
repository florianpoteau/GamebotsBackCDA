package co.simplon.gamebotsback.unit.presentation.controllers.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.web.csrf.CsrfToken;

import co.simplon.gamebotsback.presentation.controller.token.CsrfController;

class CsrfControllerTest {

    private CsrfController csrfController;

    @Mock
    CsrfToken csrfToken;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        csrfController = new CsrfController();
    }

    @Test
    void getCsrf() {

        String expectedToken = "ExpectedToken";
        when(csrfToken.getToken()).thenReturn(expectedToken);

        CsrfToken returnedToken = csrfController.getCsrf(csrfToken);

        assertEquals(expectedToken, returnedToken.getToken());
    }

}
