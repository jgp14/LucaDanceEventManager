package com.lucatic.grupo2.app.eventmanager.service;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.exceptions.EmptyListException;
import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithErrorList;
import com.lucatic.grupo2.app.eventmanager.exceptions.EventManagerException;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;

/**
 * Interfaz de servicio
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 20-03-2024
 */
public interface EventManagerService {

	/**
	 * Comprueba si existe un usuario y/o evento
	 *
	 * @param idUser  codigo de usuario
	 * @param idEvent codigo de evento
	 * @return devuelve true o false si se ha comprobado que existe
	 * @throws CheckEventUserExistException si el evento usuario no se encontro
	 */
	boolean checkUserEvent(Long idUser, Long idEvent) throws EventManagerException;

	/**
	 * Devuelve el nombre de usuario a partir del id usuario.
	 *
	 * @param idUser codio de usuario
	 * @return StringResponseWithError devuelve el nombre del usuario con error o no
	 */
	StringResponseWithError getNameUser(Long idUser) throws EventManagerException;

	/**
	 * Devuelve los eventos por nombre
	 * 
	 * @param name nombre de los eventos buscados
	 * @return EventExistResponseWithErrorList si la lista tiene elementos o no
	 */
	EventExistResponseWithErrorList findEventsByName(String name) throws EmptyListException;

}
