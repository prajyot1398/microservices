package study.microservice.hotelservice.service;

import java.util.List;

import study.microservice.hotelservice.model.HotelModel;

public interface HotelService {

    HotelModel saveHotel(HotelModel model);

    HotelModel getHotelById(String hotelId);

    List<HotelModel> getAllHotels();

    HotelModel getHotelByName(String hotelName);
}
