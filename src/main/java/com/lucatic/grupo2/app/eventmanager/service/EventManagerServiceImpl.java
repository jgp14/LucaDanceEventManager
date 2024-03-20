package com.lucatic.grupo2.app.eventmanager.service;


import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.feignclient.EventExistFeignClient;
import com.lucatic.grupo2.app.eventmanager.feignclient.UserExistFeignClient;
import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.UserExistResponseWithError;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventManagerServiceImpl implements EventManagerService {

    private final static Logger LOGGER = LogManager.getLogger(EventManagerServiceImpl.class);

    @Autowired
    private UserExistFeignClient userExistFeignClient;

    @Autowired
    private EventExistFeignClient eventExistFeignClient;

    @Override
    public boolean checkUserEvent(Long idUser, Long idEvent) throws CheckEventUserExistException {
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
                isExist = false; //
            }
            LOGGER.info("Existe usuario y evento: " + isExist);
        } catch (FeignException e) {
            LOGGER.warn(e);
            throw new CheckEventUserExistException("Error en el feign checkeando user y event");
        }
        return isExist;
    }

    public StringResponseWithError getNameUser(Long idUser) {
        return userExistFeignClient.getUserNameById(idUser);
    }
}
