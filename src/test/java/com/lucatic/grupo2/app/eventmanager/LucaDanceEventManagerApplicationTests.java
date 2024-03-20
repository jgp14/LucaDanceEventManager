package com.lucatic.grupo2.app.eventmanager;

import com.lucatic.grupo2.app.eventmanager.exceptions.EventManagerException;
import com.lucatic.grupo2.app.eventmanager.service.EventManagerService;
import feign.FeignException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LucaDanceEventManagerApplicationTests {

	@Autowired
	private EventManagerService eventManagerService;

	@Test
	void contextLoads() {
		Assertions.assertThat(true).isTrue();
	}

	@Test
	public void TestCheckUserEventIfNoExistUser() {
		assertThrows(EventManagerException.class, () -> eventManagerService.checkUserEvent(20L, 23L));
	}

	@Test
	public void TestCheckUserEventIfNoExitEvent() {
		assertThrows(EventManagerException.class, () -> eventManagerService.checkUserEvent(2L, 232L));
	}

	@Test
	public void TestCheckGetUsername() {
		assertThrows(FeignException.class, () -> eventManagerService.getNameUser(200L));
	}

	@Test
	public void TestCheckGetUsernameIfExist() {
		assertDoesNotThrow(() -> eventManagerService.getNameUser(2L));
	}


}
