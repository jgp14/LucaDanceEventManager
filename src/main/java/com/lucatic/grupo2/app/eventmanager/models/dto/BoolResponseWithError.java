package com.lucatic.grupo2.app.eventmanager.models.dto;

import com.lucatic.grupo2.app.eventmanager.models.Error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase modelo DTO BoolResponseWithError. Posee getters, setters, toString y
 * constuctores generados por Lombok @Data.
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 19-03-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoolResponseWithError {

	/** Atributo con objeto Error */
	private Error error;
	/** Atributo con atributo boolean */
	private boolean respBool;
	/** Atributo con boolean para decidir si es o no un error */
	private boolean isErrorBool;
}
