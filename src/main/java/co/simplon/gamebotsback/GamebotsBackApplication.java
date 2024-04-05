/**
 * The main application class for the GamebotsBack application.
 * This class initializes and runs the Spring Boot application.
 */
package co.simplon.gamebotsback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class represents the main entry point for the GamebotsBack application.
 * It utilizes Spring Boot's {@code @SpringBootApplication} annotation to enable
 * auto-configuration and component scanning.
 */
@SpringBootApplication
public class GamebotsBackApplication {

	/**
	 * The main method to start the GamebotsBack application.
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(GamebotsBackApplication.class, args);
	}
}
