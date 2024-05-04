package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    // Teste l'égalité entre les instances de RsaKeyProperties.
    @Test
    public void testEquality() {
        // Création de clés RSA factices pour les tests
        RSAPublicKey mockPublicKey = mock(RSAPublicKey.class);
        RSAPrivateKey mockPrivateKey = mock(RSAPrivateKey.class);

        // Création de deux instances avec les mêmes clés
        RsaKeyProperties rsaKeyProperties1 = new RsaKeyProperties(mockPublicKey, mockPrivateKey);
        RsaKeyProperties rsaKeyProperties2 = new RsaKeyProperties(mockPublicKey, mockPrivateKey);

        // Vérification que les deux instances sont égales
        assertEquals(rsaKeyProperties1, rsaKeyProperties2);

        // Modification d'une des clés dans la deuxième instance
        RSAPublicKey mockPublicKey2 = mock(RSAPublicKey.class);
        when(mockPublicKey2.getAlgorithm()).thenReturn("RSA");
        RsaKeyProperties rsaKeyProperties3 = new RsaKeyProperties(mockPublicKey2, mockPrivateKey);

        // Vérification que les instances ne sont plus égales
        assertNotEquals(rsaKeyProperties1, rsaKeyProperties3);
    }

}
