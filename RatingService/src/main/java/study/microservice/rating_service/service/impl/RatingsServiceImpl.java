package study.microservice.rating_service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.microservice.rating_service.entity.Ratings;
import study.microservice.rating_service.model.RatingsModel;
import study.microservice.rating_service.repository.RatingsRepo;
import study.microservice.rating_service.service.RatingsService;
import study.microservice.rating_service.util.RatingsUtil;

@Service
public class RatingsServiceImpl implements RatingsService {

    @Autowired
    private RatingsRepo repo;

    @Override
    public RatingsModel saveRatings(RatingsModel model) {
        
        if(model.getRatingId() != null) {
            //System.out.println("Cannot Pass Id While Creating User");
            throw new RuntimeException("Cannot Pass Id While Creating Ratings");
        }

        Ratings entity = RatingsUtil.mapModelToEntity.apply(model); 
        //Id not assigned as MongoDB assigns UUID.
        entity = this.repo.save(entity);
        return RatingsUtil.mapEntityToModel.apply(entity);
    }

    @Override
    public List<RatingsModel> getAllRatings() {
        
        return this.repo.findAll()
            .stream()
            .map((entity) -> RatingsUtil.mapEntityToModel.apply(entity))
            .toList();
    }

    @Override
    public RatingsModel getRatingsById(String id) {
        return RatingsUtil.mapEntityToModel.apply(
            this.repo.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("No Ratings Found With Id : "+id);
                }
            ));
    }

    @Override
    public List<RatingsModel> getRatingsByHotel(String hotelId) {
        
        return this.repo.findByHotelId(hotelId)
            .orElseGet(() -> new ArrayList<Ratings>())
            .stream()
            .map((ratings) -> RatingsUtil.mapEntityToModel.apply(ratings))
            .toList();
    }

    @Override
    public List<RatingsModel> getRatingsByUser(String userId) {
        return this.repo.findByUserId(userId)
        .orElseGet(() -> new ArrayList<Ratings>())
        .stream()
        .map((ratings) -> RatingsUtil.mapEntityToModel.apply(ratings))
        .toList();
    }

    @Override
    public List<RatingsModel> getByRating(int rating) {
        return this.repo.findByRating(rating)
        .orElseGet(() -> new ArrayList<Ratings>())
        .stream()
        .map((ratings) -> RatingsUtil.mapEntityToModel.apply(ratings))
        .toList();
    }

    
}
