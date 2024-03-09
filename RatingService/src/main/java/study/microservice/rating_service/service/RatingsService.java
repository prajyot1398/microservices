package study.microservice.rating_service.service;

import java.util.List;

import study.microservice.rating_service.model.RatingsModel;

public interface RatingsService {

    RatingsModel saveRatings(RatingsModel model);

    List<RatingsModel> getAllRatings();

    RatingsModel getRatingsById(String id);

    List<RatingsModel> getRatingsByHotel(String hotelId);

    List<RatingsModel> getRatingsByUser(String userId);

    List<RatingsModel> getByRating(int rating);
}
