package study.microservice.userservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import study.microservice.userservice.model.Ratings;

@FeignClient(name = "RATING-SERVICE", path = "/ratings")
public interface RatingsService {

    @GetMapping("user/{userId}")
    List<Ratings> getRatingsByUser(@PathVariable String userId);
}
