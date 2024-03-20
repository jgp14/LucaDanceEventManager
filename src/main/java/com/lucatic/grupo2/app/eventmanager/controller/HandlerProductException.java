package com.lucatic.grupo2.app.eventmanager.controller;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.models.Error;
import com.lucatic.grupo2.app.eventmanager.models.dto.BoolResponseWithError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Clase Handler que realiza el manejo personalizado de errores
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 15-03-2024
 */
@RestControllerAdvice
public class HandlerProductException {

	/**
	 * Error método error de ejecucion generico.
	 *
	 * @param e La excepción de ejecucion.
	 * @return ResponseEntity con la respuesta con su codigo de error.
	 */
	@ExceptionHandler(CheckEventUserExistException.class)
	public ResponseEntity<BoolResponseWithError> errorNoHandlerFound(CheckEventUserExistException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error en checkeando si existe usuario y evento");
		error.setMessage("Error del tipo " + e.getClass().getSimpleName());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		BoolResponseWithError boolResponseWithError = new BoolResponseWithError();
		boolResponseWithError.setErrorBool(true);
		boolResponseWithError.setError(error);
		boolResponseWithError.setRespBool(false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(boolResponseWithError);
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> errorGenericoRuntime(Exception e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error genérico procesando petición");
		error.setMessage("Error del tipo " + e.getClass().getSimpleName());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		// return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

}
