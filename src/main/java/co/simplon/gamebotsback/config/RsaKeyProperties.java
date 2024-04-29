package co.simplon.gamebotsback.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Represents RSA key properties used for JWT token encryption and decryption.
 * This class is used to load RSA public and private keys from configuration
 * properties.
 */
@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {

}
