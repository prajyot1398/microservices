package study.microservice.userservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.microservice.userservice.entity.User;
import study.microservice.userservice.model.UserModel;
import study.microservice.userservice.repository.UserRepository;
import study.microservice.userservice.service.UserService;
import study.microservice.userservice.util.UserUtil;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserModel saveUser(UserModel model) {

        if(model.getUserId() != null) {
            //System.out.println("Cannot Pass Id While Creating User");
            throw new RuntimeException("Cannot Pass Id While Creating User");
        }
        User entity = UserUtil.mapToEntity.apply(model);
        entity.setUserId(UUID.randomUUID().toString());
        entity = this.userRepo.save(entity);
        return UserUtil.mapToModel.apply(entity);
    }

    @Override
    public UserModel getUserById(String userId) {
        
        User entity = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("No User Found With Id: "+userId));
        return UserUtil.mapToModel.apply(entity);
    }

    @Override
    public List<UserModel> getAllUsers() {
        
        List<User> entityList = this.userRepo.findAll();
        List<UserModel> modelList = entityList.stream().map(UserUtil.mapToModel).toList();
        return modelList;
    }

    @Override
    public UserModel getUserByEmail(String email) {
        User entity = this.userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("No User Found With Email : " + email));
        return UserUtil.mapToModel.apply(entity);
    }
}
