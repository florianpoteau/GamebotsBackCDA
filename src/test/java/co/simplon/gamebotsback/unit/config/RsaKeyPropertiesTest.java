package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.simplon.gamebotsback.config.RsaKeyProperties;

class RsaKeyPropertiesTest {

  @Test
  @DisplayName("Test RsaKeyProperties constructor")
  void testRsaKeyProperties() {
    RSAPublicKey mockPublicKey = mock(RSAPublicKey.class);
    RSAPrivateKey mockPrivateKey = mock(RSAPrivateKey.class);

    RsaKeyProperties rsaKeyProperties = new RsaKeyProperties(mockPublicKey, mockPrivateKey);

    assertEquals(mockPublicKey, rsaKeyProperties.publicKey());
    assertEquals(mockPrivateKey, rsaKeyProperties.privateKey());
  }

  @Test
  @DisplayName("Test equality of public keys")
  void testEqualityPublicKey() {
    RSAPublicKey mockPublicKey = mock(RSAPublicKey.class);
    RSAPrivateKey mockPrivateKey = mock(RSAPrivateKey.class);

    RsaKeyProperties rsaKeyProperties1 = new RsaKeyProperties(mockPublicKey, mockPrivateKey);
    RsaKeyProperties rsaKeyProperties2 = new RsaKeyProperties(mockPublicKey, mockPrivateKey);

    assertEquals(rsaKeyProperties1, rsaKeyProperties2);

    RSAPublicKey mockPublicKey2 = mock(RSAPublicKey.class);
    when(mockPublicKey2.getAlgorithm()).thenReturn("RSA");
    RsaKeyProperties rsaKeyProperties3 = new RsaKeyProperties(mockPublicKey2, mockPrivateKey);

    assertNotEquals(rsaKeyProperties1, rsaKeyProperties3);
  }

  @Test
  @DisplayName("Test equality of private keys")
  void testEqualityPrivateKey() {
    RSAPublicKey mockPublicKey = mock(RSAPublicKey.class);
    RSAPrivateKey mockPrivateKey = mock(RSAPrivateKey.class);

    RsaKeyProperties rsaKeyProperties1 = new RsaKeyProperties(mockPublicKey, mockPrivateKey);
    RsaKeyProperties rsaKeyProperties2 = new RsaKeyProperties(mockPublicKey, mockPrivateKey);

    assertEquals(rsaKeyProperties1, rsaKeyProperties2);

    RSAPrivateKey mockPrivateKey2 = mock(RSAPrivateKey.class);
    when(mockPrivateKey2.getFormat()).thenReturn("PKCS#8");
    RsaKeyProperties rsaKeyProperties3 = new RsaKeyProperties(mockPublicKey, mockPrivateKey2);

    assertNotEquals(rsaKeyProperties1, rsaKeyProperties3);
  }

}
