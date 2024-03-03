package study.microservice.userservice.util;

import java.util.ArrayList;
import java.util.function.Function;

import study.microservice.userservice.entity.User;
import study.microservice.userservice.model.UserModel;

public class UserUtil {

    public static Function<UserModel, User> mapToEntity = (model) -> {
     
        User entity = new User();
        entity.setEmail(model.getEmail());
        entity.setName(model.getName());
        entity.setAbout(model.getAbout());
        return entity;
    };

    public static Function<User, UserModel> mapToModel = (entity) -> {
     
        UserModel model = new UserModel();
        model.setEmail(entity.getEmail());
        model.setName(entity.getName());
        model.setAbout(entity.getAbout());
        model.setUserId(entity.getUserId());

        /**
         * For now setting reviews empty, later will be fetched from other service.
        */
        model.setReviewsByUser(new ArrayList<>());
        
        return model;
    };

}
