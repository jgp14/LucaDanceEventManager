package com.lucatic.grupo2.app.eventmanager.exceptions;

/**
 * Clase personalizada de manejo de excepciones de usuario y/o evento no existen
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 20-03-2024
 */
public class CheckEventUserExistException extends EventManagerException {

	/** Genera un serial para la excepcion personalizada */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe un mensaje del fallo al comprobar si usuario existe
	 * 
	 * @param message descriptivo con el error del evento-usuario existe
	 */
	public CheckEventUserExistException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe un mensaje y la causa lanzable del fallo.
	 * 
	 * @param message descriptivo con el error del evento-usuario existe
	 * @param cause   Detalles de motivos de la causa throwable.
	 */
	public CheckEventUserExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
