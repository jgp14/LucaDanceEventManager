package com.lucatic.grupo2.app.eventmanager.service;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
<<<<<<< HEAD
import com.lucatic.grupo2.app.eventmanager.exceptions.EmptyListException;
=======
import com.lucatic.grupo2.app.eventmanager.exceptions.EventManagerException;
>>>>>>> 9a13902187a7e295cf921e3cdde1947aa4daad35
import com.lucatic.grupo2.app.eventmanager.feignclient.EventExistFeignClient;
import com.lucatic.grupo2.app.eventmanager.feignclient.UserExistFeignClient;
import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithErrorList;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.UserExistResponseWithError;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa el servicio de EventManager
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 19-03-2024
 */
@Service
public class EventManagerServiceImpl implements EventManagerService {

	/**
	 * Logger que registra los errores de clase EventManagerServiceImpl
	 */
	private final static Logger LOGGER = LogManager.getLogger(EventManagerServiceImpl.class);

	/** Auto instancia el objeto de repositorio para usuarios feignClient */
	@Autowired
	private UserExistFeignClient userExistFeignClient;

	/** Auto instancia el objeto de repositorio para eventos feignClient */

	@Autowired
	private EventExistFeignClient eventExistFeignClient;

	/**
	 * Comprueba si el usuario-evento existe
	 *
	 * @return boolean true si existe y false si no existe.
	 * @throws CheckEventUserExistException se lanza cuando hay un error al chequear
	 */
	@Override
	public boolean checkUserEvent(Long idUser, Long idEvent) throws EventManagerException {
		boolean isExist = true;

        try {
            UserExistResponseWithError userExistResponseWithError = userExistFeignClient.checkUserExist(idUser);
            if (!userExistResponseWithError.isErrorBool()) {
                if (!userExistResponseWithError.isUserExistBool()) {
                    isExist = false;
                }
            } else
                isExist = false;

            EventExistResponseWithError eventExistResponseWithError = eventExistFeignClient.checkEventExist(idEvent);

            if (!eventExistResponseWithError.isErrorBool()) {
                if (!eventExistResponseWithError.isEventExistBool()) {
                    isExist = false;
                }
            } else {
                isExist = false;
            }
            LOGGER.info("Existe usuario y evento: " + isExist);
            if (!isExist) {
                throw new CheckEventUserExistException("No existe el usuario y/o evento");
            }
        } catch (FeignException e) {
            LOGGER.warn(e);
            throw new CheckEventUserExistException("Error en el feign checkeando user y event");
        }
        return isExist;
    }
	
	/**
	 * Devuelve el nomrbe del usuario a partir de su id
	 *
	 * @param idUser codigo de usuario
	 * @return StringResponseWithError nombre del usuario con o sin error
	 */
	public StringResponseWithError getNameUser(Long idUser) throws EventManagerException {
	
	    try {
	        return userExistFeignClient.getUserNameById(idUser);
	    } catch (FeignException e) {
	        throw new EventManagerException("Error leyendo microservicio User");
	    }
	}

	@Override
	public EventExistResponseWithErrorList findEventByName(String name) throws EmptyListException {
		boolean isExist = false;
		EventExistResponseWithErrorList eventExistResponseWithErrorList;
		try {
			eventExistResponseWithErrorList = eventExistFeignClient.findEventByName(name);
			if (!eventExistResponseWithErrorList.isErrorBool()) {
				if (!eventExistResponseWithErrorList.isEventListExistBool()) {
					isExist = false;
				}
			} else {
				isExist = false;
			}
			LOGGER.info("Existe lista de eventos por nombre: " + isExist);
		} catch (FeignException e) {
			LOGGER.warn(e);
			throw new EmptyListException("Error en el feign listando eventos por nombre");
		}
		eventExistResponseWithErrorList.setEventListExistBool(isExist);
		return eventExistResponseWithErrorList;
	}
	
}
