package com.lucatic.grupo2.app.eventmanager.controller;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.models.dto.BoolResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.service.EventManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

	@Autowired
	private EventManagerService eventManagerService;

	@Operation(summary = "Comprueba la existencia de un usuario y evento por id", description = "Devuelve la existencia de un usuario y evento", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Comprueba usuario y evento", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoolResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay usuarios y/o eventos con ese id", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando evento y/o usuario", content = @Content)

	})
	@GetMapping("/checkExist/{idUser}/{idEvent}")
	public ResponseEntity<?> checkUserEvent(@PathVariable Long idUser, @PathVariable Long idEvent)
			throws CheckEventUserExistException {
		BoolResponseWithError boolResponseWithError = new BoolResponseWithError();
		if ((eventManagerService.checkUserEvent(idUser, idEvent))) {
			boolResponseWithError.setRespBool(true);
		} else {
			boolResponseWithError.setErrorBool(false);
		}
		boolResponseWithError.setError(null);
		boolResponseWithError.setErrorBool(false);
		return ResponseEntity.ok(boolResponseWithError);
	}

	@Operation(summary = "Comprueba la existencia de un usuario por id", description = "Devuelve la existencia de un usuario", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(description = "Comprueba un usuario", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StringResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay usuario con ese id", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico mostrando usuario", content = @Content)

	})
	@GetMapping("/getUser/{idUser}")
	public ResponseEntity<?> getNameUser(@PathVariable Long idUser) {
		StringResponseWithError stringResponseWithError = eventManagerService.getNameUser(idUser);
		stringResponseWithError.setError(null);
		stringResponseWithError.setErrorBool(false);
		return ResponseEntity.ok().body(stringResponseWithError);
	}
}
