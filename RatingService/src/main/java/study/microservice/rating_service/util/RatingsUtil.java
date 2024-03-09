package study.microservice.rating_service.util;

import java.util.function.Function;

import study.microservice.rating_service.entity.Ratings;
import study.microservice.rating_service.model.RatingsModel;

public class RatingsUtil {

    public static Function<Ratings, RatingsModel> mapEntityToModel = (entity) -> {
        return  RatingsModel
            .builder()
            .ratingId(entity.getRatingId())
            .ratings(entity.getRating())
            .hotelId(entity.getHotelId())
            .userId(entity.getUserId())
            .reviewComment(entity.getReviewComment())
            .build();
    };

    public static Function<RatingsModel, Ratings> mapModelToEntity = (model) -> {
        return Ratings.builder()
            .hotelId(model.getHotelId())
            .rating(model.getRatings())
            .reviewComment(model.getReviewComment())
            .userId(model.getUserId())
            .build();
    }; 
}
