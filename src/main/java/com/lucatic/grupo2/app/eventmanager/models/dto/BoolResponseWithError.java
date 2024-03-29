package com.lucatic.grupo2.app.eventmanager.models.dto;

import com.lucatic.grupo2.app.eventmanager.models.Error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoolResponseWithError {

    /**
     * Atributo con objeto Error
     */
    private Error error;
    /**
     * Atributo con atributo boolean
     */
    private boolean respBool;
    /**
     * Atributo con boolean para decidir si es o no un error
     */
    private boolean isErrorBool;
}
