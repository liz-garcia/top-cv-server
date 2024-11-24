package com.topcv.topcvserver;

import io.github.cdimascio.dotenv.Dotenv;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application. Initializes environment variables and starts the Spring context.
 */
@SpringBootApplication
public class TopCvServerApplication {

  /**
   * Initializes the application by loading environment variables from the .env file. This method is
   * executed after the Spring context is fully initialized. Sets the MONGODB_URI as a system
   * property for Spring Boot to use.
   */
  @PostConstruct
  public void init() {
    String mongodbUri = null;

    // Load the .env file (for local development)
    Dotenv dotenv = Dotenv.configure().load();
    mongodbUri = dotenv.get("MONGODB_URI");

    // If not found in .env, check environment variables (for Heroku)
    if (mongodbUri == null) {
      mongodbUri = System.getenv("MONGODB_URI");
    }

    // If we have a valid mongodbUri, set it as a system property
    if (mongodbUri != null) {
      System.setProperty("MONGODB_URI", mongodbUri);
      // Log for debugging
      System.out.println("MONGODB_URI: " + mongodbUri);
    } else {
      // If MongoDB URI is not found, throw an error or handle the case as needed
      System.err.println("MONGODB_URI is not set! Please configure it in your environment.");
      // Optionally throw an exception
      throw new RuntimeException("MONGODB_URI is not set.");
    }
  }

  /** Main method to run the Spring Boot application. */
  public static void main(String[] args) {
    SpringApplication.run(TopCvServerApplication.class, args);
  }
}
