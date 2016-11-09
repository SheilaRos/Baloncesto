package com.example;

import com.example.service.PlayerService;
import com.example.service.TeamService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BaloncestoApplication.class, args);
		context.getBean(TeamService.class).testTeam();
        context.getBean(PlayerService.class).testPlayer();
	}
}
