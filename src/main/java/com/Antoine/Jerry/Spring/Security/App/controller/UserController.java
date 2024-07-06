package com.Antoine.Jerry.Spring.Security.App.controller;

import com.Antoine.Jerry.Spring.Security.App.model.AuthenticationRequest;
import com.Antoine.Jerry.Spring.Security.App.model.AuthenticationResponse;
import com.Antoine.Jerry.Spring.Security.App.model.User;
import com.Antoine.Jerry.Spring.Security.App.request.UserRegistrationRequest;
import com.Antoine.Jerry.Spring.Security.App.request.UserUpdateRequest;
import com.Antoine.Jerry.Spring.Security.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        return userService.saveUser(userRegistrationRequest);
    }

    @PostMapping("/login")
    public AuthenticationResponse authenticationResponse(@RequestBody AuthenticationRequest authenticationRequest){
        return  userService.userLogin(authenticationRequest);
    }
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserUpdateRequest userUpdateRequest){
        //UserUpdateRequest updateRequest = new UserUpdateRequest();
        return userService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
