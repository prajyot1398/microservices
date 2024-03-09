package study.microservice.rating_service.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import study.microservice.rating_service.entity.Ratings;

public interface RatingsRepo extends MongoRepository<Ratings, String>{
    
    Optional<List<Ratings>> findByUserId(String userId);
    Optional<List<Ratings>> findByHotelId(String hotelId);
    Optional<List<Ratings>> findByRating(int rating);
}
