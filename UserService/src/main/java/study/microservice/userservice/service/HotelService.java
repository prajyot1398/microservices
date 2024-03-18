package study.microservice.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import study.microservice.userservice.model.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("hotel/id/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
