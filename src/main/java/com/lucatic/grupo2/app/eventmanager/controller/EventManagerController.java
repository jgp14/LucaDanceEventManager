package com.lucatic.grupo2.app.eventmanager.controller;

import com.lucatic.grupo2.app.eventmanager.exceptions.CheckEventUserExistException;
import com.lucatic.grupo2.app.eventmanager.models.dto.BoolResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.service.EventManagerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

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

    @GetMapping("/checkExist/{idUser}/{idEvent}")
    public ResponseEntity<?> checkUserEvent(@PathVariable Long idUser, @PathVariable Long idEvent) throws CheckEventUserExistException {
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


    @GetMapping("/getUser/{idUser}")
    public ResponseEntity<?> getNameUser(@PathVariable Long idUser) {
        StringResponseWithError stringResponseWithError = eventManagerService.getNameUser(idUser);
        stringResponseWithError.setError(null);
        stringResponseWithError.setErrorBool(false);
        return ResponseEntity.ok().body(stringResponseWithError);
    }
}
