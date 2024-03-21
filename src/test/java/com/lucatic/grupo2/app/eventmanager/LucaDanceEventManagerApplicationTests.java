package com.lucatic.grupo2.app.eventmanager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.service.EventManagerService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LucaDanceEventManagerApplicationTests {

	/** Inyectar servicio*/
	@Autowired
	private EventManagerService eventManagerService;

	@Test
	void contextLoads() {
		Assertions.assertThat(true).isTrue();
	}

	/** Test obtener el nombre de un usuario por id correctamente */
	@Test
	void getUserNameByIdIfExists() {
		assertEquals("Juan", eventManagerService.getNameUser(2L).getUserExistText());
	}

	/** Test lanzar excecion de un usuario por id si el usuario no existe */
	@Test
	void getUserNameByIdIfNotExists() {
		assertThrows(Exception.class, () -> eventManagerService.getNameUser(100L).getUserExistText());
	}

	/** Test comprobar si un usuario-evento existe por identificadores 
	 * @throws CheckEventUserExistException */
	@Test
	void getCheckUserEventIfExistsByIds() throws CheckEventUserExistException {
		assertEquals(true, eventManagerService.checkUserEvent(2L, 23L));
	}

	/** Test comprobar si un usuario-evento no existe por ids de usuario y evento */
	@Test
	void getCheckUserEventIfNotExistsByIds() throws Exception{
		assertEquals(false,  eventManagerService.checkUserEvent(15L, 100L));
	}
}
