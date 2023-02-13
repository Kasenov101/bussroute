package com.nadex.bussroute;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

@SpringBootApplication
public class BussRouteApplication {
    @Value("${buss.route.path}")
    private String path;

    @Bean("BufferedReader")
    public BufferedReader getReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(Paths.get(path).toFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reader;
    }
    public static void main(String[] args) {
        SpringApplication.run(BussRouteApplication.class, args);
    }

}
