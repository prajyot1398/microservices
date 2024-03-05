package study.microservice.hotelservice.controller;

import org.springframework.web.bind.annotation.RestController;

import study.microservice.hotelservice.model.HotelModel;
import study.microservice.hotelservice.service.HotelService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping
    public ResponseEntity<List<HotelModel>> getAllHotels() {
        return new ResponseEntity<>(this.service.getAllHotels(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<HotelModel> saveHotel(@RequestBody HotelModel model) {
        return new ResponseEntity<>(this.service.saveHotel(model), HttpStatus.CREATED);
    }

    @GetMapping("id/{hotelId}")
    public ResponseEntity<HotelModel> getHotelById(@PathVariable String hotelId) {
        return new ResponseEntity<>(this.service.getHotelById(hotelId), HttpStatus.OK);
    }

    // @GetMapping("name/{hotelName}")
    // public ResponseEntity<HotelModel> getHotelByName(@PathVariable String hotelName) {
    //     return new ResponseEntity<>(this.service.getHotelByName(hotelName), HttpStatus.OK);
    // }
}
