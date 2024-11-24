package com.topcv.topcvserver;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.Objects;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopCvServerApplication {

    @PostConstruct
    public void init() {
        // Load the .env file
        Dotenv dotenv = Dotenv.configure().load();
        // Set the MONGODB_URI as a system property for Spring Boot to use
        System.setProperty("MONGODB_URI", Objects.requireNonNull(dotenv.get("MONGODB_URI")));
    }

    public static void main(String[] args) {
        SpringApplication.run(TopCvServerApplication.class, args);
    }

}
