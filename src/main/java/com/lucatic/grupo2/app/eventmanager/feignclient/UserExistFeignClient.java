package com.lucatic.grupo2.app.eventmanager.feignclient;


import com.lucatic.grupo2.app.eventmanager.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.eventmanager.models.dto.UserExistResponseWithError;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users")
public interface UserExistFeignClient {

    @GetMapping("/user/exist/{idUser}")
    UserExistResponseWithError checkUserExist(@PathVariable Long idUser);

    @GetMapping("/user/getname/{idUser}")
    StringResponseWithError getUserNameById(@PathVariable Long idUser);
}
