package com.throwawaycode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration

public class TonyasCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(TonyasCliApplication.class, args);
	}




    @Value("${cli.message}")
    private String message;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> {
            System.out.println("=========================================================");
            System.out.println("Put your run logic here.  Also dont use system out!");
            System.out.println("message=" + message);
            System.out.println("=========================================================");

        };
    }
}
