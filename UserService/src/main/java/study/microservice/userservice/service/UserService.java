package study.microservice.userservice.service;

import java.util.List;

import study.microservice.userservice.model.UserModel;

public interface UserService {

    UserModel saveUser(UserModel model);

    UserModel getUserById(String userId);

    List<UserModel> getAllUsers();

    UserModel getUserByEmail(String email);
}
