package com.lucatic.grupo2.app.eventmanager.service;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.exceptions.EventManagerException;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;

public interface EventManagerService {

    boolean checkUserEvent(Long idUser, Long idEvent) throws EventManagerException;
    StringResponseWithError getNameUser(Long idUser) throws EventManagerException;
}
