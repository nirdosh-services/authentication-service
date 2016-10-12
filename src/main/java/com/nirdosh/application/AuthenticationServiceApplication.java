package com.nirdosh.application;

import com.nirdosh.domain.model.UserBuilder;
import com.nirdosh.infrastructure.persistence.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.nirdosh")
@EnableMongoRepositories("com.nirdosh.infrastructure.persistence")
public class AuthenticationServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	@Autowired
	private UserRepo userRepo;

	@Override
	public void run(String... strings) throws Exception {
		UserBuilder userBuilder = new UserBuilder()
									.userName("manav")
									.password("wefor2015")
									.role("ROLE_FTPADMIN")
									.role("ROLE_READER");
		userRepo.save(userBuilder.build());
	}
}
