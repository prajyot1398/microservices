package study.microservice.userservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

import lombok.extern.slf4j.Slf4j;
import study.microservice.userservice.entity.User;
import study.microservice.userservice.model.Hotel;
import study.microservice.userservice.model.Ratings;
import study.microservice.userservice.model.UserModel;
import study.microservice.userservice.repository.UserRepository;
import study.microservice.userservice.service.HotelService;
import study.microservice.userservice.service.RatingsService;
import study.microservice.userservice.service.UserService;
import study.microservice.userservice.util.UserUtil;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingsService ratingsService;

    @Override
    public UserModel saveUser(UserModel model) {

        log.debug("In saveUser()");
        if(model.getUserId() != null) {
            //System.out.println("Cannot Pass Id While Creating User");
            throw new RuntimeException("Cannot Pass Id While Creating User");
        }
        User entity = UserUtil.mapToEntity.apply(model);
        entity.setUserId(UUID.randomUUID().toString());
        entity = this.userRepo.save(entity);
        log.debug("End saveUser()");
        return UserUtil.mapToModel.apply(entity);
    }

    private List<Ratings> fetchRatingsAndHotelsForUser(String userId) {
        //Fetching in Ratings[] because RestTemplate may cannot convert to ArrayList and stores data in LinkedHashMap instead of List and
        //therefore cannot use stream on it, so get in Array and convert into list.

        //Use of RestTemplate
        // Ratings[] ratings  = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId, Ratings[].class);
        // List<Ratings> ratingsList =  Arrays.stream(ratings).toList();

        //Use of FeignClient
        List<Ratings> ratingsList = this.ratingsService.getRatingsByUser(userId);
        ratingsList.stream().forEach(rating -> {
            // Hotel hotel = this.restTemplate.getForObject("http://HOTEL-SERVICE/hotel/id/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = this.hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
        });

        return ratingsList;
    }

    @Override
    public UserModel getUserById(String userId) {
        
        log.trace("In getUserById()");
        User entity = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("No User Found With Id: "+userId));

        UserModel model =  UserUtil.mapToModel.apply(entity);
        
        log.info("In getUserById Added By My Logger");

        List<Ratings> fetchedRatings = fetchRatingsAndHotelsForUser(model.getUserId());

        model.setReviewsByUser(fetchedRatings);
        log.trace("End getUserById()");
        return model;
    }

    @Override
    public List<UserModel> getAllUsers() {
        
        List<User> entityList = this.userRepo.findAll();
        List<UserModel> modelList = entityList.stream().map(
            (entity) -> {
                UserModel model = UserUtil.mapToModel.apply(entity);
                model.setReviewsByUser(this.fetchRatingsAndHotelsForUser(model.getUserId()));
                return model;
            }).toList();
        return modelList;
    }

    @Override
    public UserModel getUserByEmail(String email) {
        User entity = this.userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("No User Found With Email : " + email));
        return UserUtil.mapToModel.apply(entity);
    }
}
