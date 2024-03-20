package com.lucatic.grupo2.app.eventmanager.feignclient;

import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithError;
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
}
