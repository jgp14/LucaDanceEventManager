package com.lucatic.grupo2.app.eventmanager.feignclient;

import com.lucatic.grupo2.app.eventmanager.models.dto.EventExistResponseWithError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "events")
public interface EventExistFeignClient {

    @GetMapping("/event/exists/{idEvent}")
    EventExistResponseWithError checkEventExist(@PathVariable Long idEvent);
}
