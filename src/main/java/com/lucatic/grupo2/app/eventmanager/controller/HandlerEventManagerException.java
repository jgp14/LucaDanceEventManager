package com.lucatic.grupo2.app.eventmanager.controller;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.exceptions.EventManagerException;
import com.lucatic.grupo2.app.eventmanager.models.Error;
import com.lucatic.grupo2.app.eventmanager.models.dto.BoolResponseWithError;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

/**
 * Clase Handler que realiza el manejo personalizado de errores
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 15-03-2024
 */
@RestControllerAdvice
public class HandlerEventManagerException {

	/** Logger que registra los errores de clase HandlerProductException */
	private final static Logger LOGGER = LogManager.getLogger(HandlerEventManagerException.class);

	/**
	 * Error método de no Handler Encontrado
	 *
	 * @param e La excepción de CheckEventUserExists.
	 * @return ResponseEntity con la respuesta y su codigo de error.
	 */
	@ExceptionHandler(CheckEventUserExistException.class)
	public ResponseEntity<BoolResponseWithError> errorNoHandlerFound(CheckEventUserExistException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error en checkeando si existe usuario y evento");
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.OK.value());
		BoolResponseWithError boolResponseWithError = new BoolResponseWithError();
		boolResponseWithError.setErrorBool(true);
		boolResponseWithError.setError(error);
		boolResponseWithError.setRespBool(false);
		LOGGER.warn(error.getMessage());
		return ResponseEntity.status(HttpStatus.OK.value()).body(boolResponseWithError);
	}

	/**
	 * Error método generico de ejecucion
	 *
	 * @param e La excepción de ejecucion.
	 * @return ResponseEntity con la respuesta con su codigo de error.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> errorGenericoRuntime(Exception e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error genérico procesando petición");
		error.setMessage("Error del tipo genérico");
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		LOGGER.warn(error.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

	@ExceptionHandler(EventManagerException.class)
	public ResponseEntity<Error> errorGenericoRuntime(EventManagerException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error de gestión de event manager");
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		// return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
	}


	/**
	 * Error de tipo argumento de método no válido
	 *
	 * @param e La excepción
	 * @return Un BADREQUEST con eventResponseWithError
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> errorGenericoRuntime(MethodArgumentNotValidException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error en los datos del cliente, compruebelos");
		error.setMessage(e.getMessage().split(":")[1]);
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		// return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

	/**
	 * Error de excepcion no se encontro el Handler.
	 *
	 * @param e La excepcion de handler no encontrado.
	 * @return esponseEntity con la respuesta del error.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Error> errorNoHandlerFound(NoHandlerFoundException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error en la URL");
		error.setMessage("Error buscando manejador de petición");
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		// return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

	/**
	 * Error de excepcion por Resquest Metodo no soportado.
	 *
	 * @param e La excepcion de metodo no esta soportado.
	 * @return ResponseEntity con la respuesta del error.
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Error> errorNoHandlerFound(HttpRequestMethodNotSupportedException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error en la URL");
		error.setMessage("Error en el tipo de método HTTP de peticion");
		error.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		// return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED.value()).body(error);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Error> errorHttpMessageNotReadable(HttpMessageNotReadableException e) {
		Error error = new Error();
		error.setDate(LocalDateTime.now());
		error.setError("Error en los campos del json");
		error.setMessage("Introduce correctamente los datos y su formato");
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		// return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

}
