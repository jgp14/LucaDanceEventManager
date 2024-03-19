package com.lucatic.grupo2.app.eventmanager.service;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface EventManagerService {

    boolean checkUserEvent(Long idUser, Long idEvent) throws CheckEventUserExistException;
    StringResponseWithError getNameUser(Long idUser);
}
