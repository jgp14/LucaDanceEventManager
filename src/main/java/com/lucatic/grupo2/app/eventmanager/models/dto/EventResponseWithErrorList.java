package com.lucatic.grupo2.app.eventmanager.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseWithErrorList {
	/**
	 * Atributo con objeto Error
	 */
	private Error error;
	/**
	 * Atributo con objeto UserResponse
	 */
	private List<EventResponse> eventResponse;
	/**
	 * Atributo con boolean para decidir si es o no un error
	 */
	private boolean isErrorBool;
}
