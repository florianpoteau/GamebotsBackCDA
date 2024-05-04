package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.junit.jupiter.api.Test;

import co.simplon.gamebotsback.config.RsaKeyProperties;

public class RsaKeyPropertiesTest {

    @Test
    public void testRsaKeyProperties() {
        // Création de clés RSA factices pour les tests
        RSAPublicKey mockPublicKey = mock(RSAPublicKey.class);
        RSAPrivateKey mockPrivateKey = mock(RSAPrivateKey.class);

        // Création d'une instance de RsaKeyProperties
        RsaKeyProperties rsaKeyProperties = new RsaKeyProperties(mockPublicKey, mockPrivateKey);

        // Vérification que les clés sont correctement attribuées
        assertEquals(mockPublicKey, rsaKeyProperties.publicKey());
        assertEquals(mockPrivateKey, rsaKeyProperties.privateKey());
    }

}
