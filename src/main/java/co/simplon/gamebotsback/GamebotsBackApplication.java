package co.simplon.gamebotsback;

import co.simplon.gamebotsback.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * This class represents the main entry
 * point for the GamebotsBack application.
 * It utilizes Spring Boot's {@code @SpringBootApplication}
 * annotation to enable
 * autoconfiguration and component scanning.
 */
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class GamebotsBackApplication {

  /**
   * Main method to start the GamebotsBack application.
   *
   * @param args
   *     Command-line arguments passed to the application.
   */
  public static void main(final String[] args) {
    SpringApplication.run(GamebotsBackApplication.class, args);
  }
}
