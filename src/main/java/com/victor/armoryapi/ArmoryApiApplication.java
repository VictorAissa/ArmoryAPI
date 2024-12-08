package com.victor.armoryapi;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class ArmoryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmoryApiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing Armory API : TEST CHANGES");
        try (InputStream input = new FileInputStream("local.env")) {
            Properties prop = new Properties();
            prop.load(input);
            prop.forEach((key, value) -> System.setProperty((String) key, (String) value));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}