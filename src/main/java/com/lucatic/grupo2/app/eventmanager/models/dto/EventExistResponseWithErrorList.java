package com.lucatic.grupo2.app.eventmanager.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventExistResponseWithErrorList {
	/**
	 * Atributo con objeto Error
	 */
	private Error error;
	/**
	 * Atributo boolean si existe lista eventos
	 */
	private boolean eventListExistBool;
	/**
	 * Atributo con boolean para decidir si es o no un error
	 */
	private boolean isErrorBool;
}
