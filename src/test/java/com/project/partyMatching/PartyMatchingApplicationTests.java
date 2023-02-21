package com.project.partyMatching;

import com.project.partyMatching.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartyMatchingApplicationTests {

	@Autowired
	private UserMapper mapper;
	@Test
	void testBatis() {
		mapper.testInsert();
	}

}
