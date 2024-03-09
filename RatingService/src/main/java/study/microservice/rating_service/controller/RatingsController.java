package study.microservice.rating_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.microservice.rating_service.model.RatingsModel;
import study.microservice.rating_service.service.RatingsService;


@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingsService service;

    @PostMapping
    public ResponseEntity<RatingsModel> saveRatings(@RequestBody RatingsModel model) {
        return new ResponseEntity<>(this.service.saveRatings(model), HttpStatus.CREATED);
    }    

    @GetMapping
    public ResponseEntity<List<RatingsModel>> getAllRatings() {
        return new ResponseEntity<>(this.service.getAllRatings(), HttpStatus.OK);
    }

    @GetMapping("id/{ratingId}")
    public ResponseEntity<RatingsModel> getRatingsById(@PathVariable String ratingId) {
        return new ResponseEntity<>(this.service.getRatingsById(ratingId), HttpStatus.OK);
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<RatingsModel>> getRatingsByHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok().body(this.service.getRatingsByHotel(hotelId));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<RatingsModel>> getRatingsByUser(@PathVariable String userId) {
        return ResponseEntity.ok().body(this.service.getRatingsByUser(userId));
    }
    
    
}   
