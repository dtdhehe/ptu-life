package com.dtdhehe.ptulife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableScheduling
@Controller
public class PtuLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtuLifeApplication.class, args);
	}

	@RequestMapping("/index")
	public String getIndex(){
		return "index/login";
	}

}
