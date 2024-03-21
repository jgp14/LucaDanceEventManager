package com.lucatic.grupo2.app.eventmanager.controller;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.exceptions.EventManagerException;
import com.lucatic.grupo2.app.eventmanager.models.dto.BoolResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.EventResponseWithErrorList;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.service.EventManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controladora, toma las decisiones de la aplicacion
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 19-03-2024
 */
@RestController
@RequestMapping("/eventmanager")
public class EventManagerController {

	/** Logger que registra los errores de clase EventManagerController */
	private static final Logger LOGGER = LogManager.getLogger(EventManagerController.class);

	/** Auto instanciamos el servicio de eventManager */
	@Autowired
	private EventManagerService eventManagerService;

	/**
	 * Comprueba la existencia de un usuario y evento por id.
	 * 
	 * @param idUser  Con el id de usuario a buscar
	 * @param idEvent Con el id de evento a buscar
	 * @return ResponseEntity Con la respuesta buscar, o encontrar usuario evento.
	 * @throws CheckEventUserExistException cuando no se encontro usuario y/o evento
	 *                                      con ese id.
	 */
	@Operation(summary = "Comprueba la existencia de un usuario y evento por id", description = "Devuelve la existencia de un usuario y evento", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Comprueba usuario y evento", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoolResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay usuarios y/o eventos con ese id", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando evento y/o usuario", content = @Content)

	})
	@GetMapping("/checkExist/{idUser}/{idEvent}")
	public ResponseEntity<?> checkUserEvent(@PathVariable Long idUser, @PathVariable Long idEvent)
			throws EventManagerException {

		BoolResponseWithError boolResponseWithError = new BoolResponseWithError();

		if ((eventManagerService.checkUserEvent(idUser, idEvent))) {
			boolResponseWithError.setRespBool(true);
		} else {
			boolResponseWithError.setRespBool(false);
		}

		boolResponseWithError.setError(null);
		boolResponseWithError.setErrorBool(false);

		LOGGER.info(boolResponseWithError);

		return ResponseEntity.ok(boolResponseWithError);
	}

	/**
	 * Devuelve el nombre de usuario a partir de su id.
	 * 
	 * @param idUser identificador de usuario a buscar
	 * @return ResponseEntity Con la respuesta al obtener el nombre de usuario.
	 * @throws EventManagerException cuando no seobtiene el usuaroi
	 */
	@Operation(summary = "Comprueba la existencia de un usuario por id", description = "Devuelve la existencia de un usuario", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Comprueba un usuario", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StringResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay usuario con ese id", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando usuario", content = @Content)

	})
	@GetMapping("/getUser/{idUser}")
	public ResponseEntity<?> getNameUser(@PathVariable Long idUser) throws EventManagerException {

		StringResponseWithError stringResponseWithError = eventManagerService.getNameUser(idUser);
		stringResponseWithError.setError(null);
		stringResponseWithError.setErrorBool(false);
		LOGGER.info(stringResponseWithError);
		return ResponseEntity.ok().body(stringResponseWithError);
	}

	/**
	 * Devuelve lista de eventos a partid de nombre de evento.
	 * 
	 * @param name nombre de los eventos a buscar.
	 * @return ResponseEntity Con la respuesta al obtener la lista de eventos
	 * @throws EventManagerException cuando se produce un error al mostrar lista.
	 */
	@Operation(summary = "Encuentra y lista los eventos por nombre", description = "Devuelve lista con los eventos con un nombre concreto", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Encontrar eventos por nombre", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StringResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay eventos con ese nombre", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando lista eventos", content = @Content)

	})
	@GetMapping("/event/name/{name}")
	public ResponseEntity<?> findEventsByName(@PathVariable String name) throws EventManagerException {
		EventResponseWithErrorList eventExistResponseWithErrorList = eventManagerService.findEventsByName(name);
		eventExistResponseWithErrorList.setError(null);
		eventExistResponseWithErrorList.setErrorBool(false);
		LOGGER.info(eventExistResponseWithErrorList);
		return ResponseEntity.ok().body(eventExistResponseWithErrorList);
	}

	/**
	 * Devuelve lista de eventos a partir del genero de evento.
	 * 
	 * @param roomtype genero de los eventos a buscar.
	 * @return ResponseEntity Con la respuesta al obtener la lista de eventos
	 * @throws EventManagerException cuando se produce un error al mostrar lista.
	 */
	@Operation(summary = "Encuentra y lista los eventos por genero", description = "Devuelve lista con los eventos con un genero concreto", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Encontrar eventos por genero", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StringResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay eventos con ese genero", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando lista eventos", content = @Content)

	})
	@GetMapping("/event/roomtype/{roomtype}")
	public ResponseEntity<?> findEventsByRoomType(@PathVariable String roomtype) throws EventManagerException {
		EventResponseWithErrorList eventExistResponseWithErrorList = eventManagerService.findEventsByRoomType(roomtype);
		eventExistResponseWithErrorList.setError(null);
		eventExistResponseWithErrorList.setErrorBool(false);
		LOGGER.info(eventExistResponseWithErrorList);
		return ResponseEntity.ok().body(eventExistResponseWithErrorList);
	}

	/**
	 * Devuelve lista de eventos a partir de la ciudad del evento.
	 * 
	 * @param city ciudad de los eventos a buscar.
	 * @return ResponseEntity Con la respuesta al obtener la lista de eventos
	 * @throws EventManagerException cuando se produce un error al mostrar lista.
	 */
	@Operation(summary = "Encuentra y lista los eventos por ciudad", description = "Devuelve lista con los eventos por una ciudad concreta", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Encontrar eventos por ciudad", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StringResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay eventos con esa ciudad", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando lista eventos", content = @Content)

	})
	@GetMapping("/event/city/{city}")
	public ResponseEntity<?> findEventsByCity(@PathVariable String city) throws EventManagerException {
		EventResponseWithErrorList eventExistResponseWithErrorList = eventManagerService.findEventsByCity(city);
		eventExistResponseWithErrorList.setError(null);
		eventExistResponseWithErrorList.setErrorBool(false);
		LOGGER.info(eventExistResponseWithErrorList);
		return ResponseEntity.ok().body(eventExistResponseWithErrorList);
	}
}
