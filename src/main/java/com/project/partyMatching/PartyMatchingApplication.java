package com.project.partyMatching;

import com.project.partyMatching.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PartyMatchingApplication {

	@Autowired
	private UserMapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(PartyMatchingApplication.class, args);

	}


}
