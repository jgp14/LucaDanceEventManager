package com.lucatic.grupo2.app.eventmanager.feignclient;

import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithError;

import com.lucatic.grupo2.app.eventmanager.models.dto.EventResponseWithErrorList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interfaz de cliente Feign para eventos, si evento existe
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 15-03-2024
 */
@FeignClient(name = "events")
public interface EventExistFeignClient {

	/**
	 * Mapeo del endpoint para si un evento existe
	 * 
	 * @param idEvent el identificador del evento
	 * @return EventExistResponseWithError con el mensaje de si el evento existe o
	 *         no
	 */
	@GetMapping("/event/exists/{idEvent}")
	EventExistResponseWithError checkEventExist(@PathVariable Long idEvent);

	/**
	 * Mapeo del endpoint para si hay lista de eventos
	 * 
	 * @param name el nombre de busqueda de los eventos.
	 * @return EventExistResponseWithErrorList con el mensaje de si la lista de
	 *         eventos por nombre existe
	 */
	@GetMapping("/event/search/{name}")
	EventResponseWithErrorList findEventByName(@PathVariable String name);

	/**
	 * Mapeo del endpoint para si hay lista de eventos
	 * 
	 * @param roomtype el tipo de sala o genero de busqueda de los eventos.
	 * @return EventExistResponseWithErrorList con el mensaje de si la lista de
	 *         eventos por genero existe
	 */
	@GetMapping("/event/eventsbyroom/{roomtype}")
	EventResponseWithErrorList findEventByRoomType(@PathVariable String roomtype);

	/**
	 * Mapeo del endpoint para si hay lista de eventos
	 * 
	 * @param ciudad la ciudad de busqueda de los eventos.
	 * @return EventExistResponseWithErrorList con el mensaje de si la lista de
	 *         eventos por ciudad
	 */
	@GetMapping("/event/eventsbycity/{cityName}")
	EventResponseWithErrorList findEventByCity(@PathVariable String cityName);

}
