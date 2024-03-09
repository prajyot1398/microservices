package study.microservice.hotelservice.util;

import java.util.ArrayList;
import java.util.function.Function;

import study.microservice.hotelservice.entity.Hotel;
import study.microservice.hotelservice.model.HotelModel;
import study.microservice.hotelservice.model.Ratings;

public class HotelUtil {

    public static Function<Hotel, HotelModel> mapEntityToModel = (entity) -> {
        return HotelModel.builder()
            .hotelId(entity.getId())
            .hotelLocation(entity.getLocation())
            .hotelName(entity.getHotelName())
            .about(entity.getAbout())
            .reviewsForHotel(new ArrayList<Ratings>())
            .build();
    };

    public static Function<HotelModel, Hotel> mapModelToEntity = (model) -> {
        return Hotel.builder()
            .id(model.getHotelId())
            .location(model.getHotelLocation())
            .hotelName(model.getHotelName())
            .about(model.getAbout())
            .build();
    };
}
