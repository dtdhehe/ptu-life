package com.dtdhehe.ptulife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PtuLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtuLifeApplication.class, args);
	}
}
