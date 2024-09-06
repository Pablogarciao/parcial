package com.example.parcial;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParcialApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        // Programmatically set system properties so Spring can access them
        System.setProperty("CONNECTION_URL",
                dotenv.get("CONNECTION_URL"));

        System.setProperty("USER",
                dotenv.get("USER"));

        System.setProperty("PASSWORD",
                dotenv.get("PASSWORD"));

        System.setProperty("SERVER_PORT",
                dotenv.get("SERVER_PORT"));

        System.setProperty("SPRING_APPLICATION_NAME",
                dotenv.get("SPRING_APPLICATION_NAME"));

        SpringApplication.run(ParcialApplication.class, args);
    }

}
