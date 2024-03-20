package com.lucatic.grupo2.app.eventmanager.feignclient;

import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.UserExistResponseWithError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interfaz de cliente Feign para usuarios, si usuario existe
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 15-03-2024
 */
@FeignClient(name = "users")
public interface UserExistFeignClient {

	/**
	 * Mapeo del endpoint para obtener si un usuario existe
	 * 
	 * @param idUser el identificador del usuario
	 * @return UserExistResponseWithError con el mensaje de si user existe o no.
	 */
	@GetMapping("/user/exist/{idUser}")
	UserExistResponseWithError checkUserExist(@PathVariable Long idUser);

	/**
	 * Mapeo del endpoint para obtener el nombre de usuario por su id.
	 * 
	 * @param idUser el identificador del usuario
	 * @return StringResponseWithError con el mensaje del nombre usuario o error.
	 */
	@GetMapping("/user/getname/{idUser}")
	StringResponseWithError getUserNameById(@PathVariable Long idUser);
}
