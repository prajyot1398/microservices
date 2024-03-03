
package study.microservice.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.microservice.userservice.model.UserModel;
import study.microservice.userservice.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel model) {

        return new ResponseEntity<>(service.saveUser(model), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {

        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<UserModel> getUserById(@RequestBody String userId) {
        return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<UserModel> getUserByEmail(@RequestBody String email) {
        return new ResponseEntity<>(service.getUserByEmail(email), HttpStatus.OK);
    }
}
