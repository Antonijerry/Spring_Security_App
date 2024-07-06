package com.Antoine.Jerry.Spring.Security.App.service;

import com.Antoine.Jerry.Spring.Security.App.model.AuthenticationRequest;
import com.Antoine.Jerry.Spring.Security.App.model.AuthenticationResponse;
import com.Antoine.Jerry.Spring.Security.App.model.User;
import com.Antoine.Jerry.Spring.Security.App.repository.UserRepository;
import com.Antoine.Jerry.Spring.Security.App.request.UserRegistrationRequest;
import com.Antoine.Jerry.Spring.Security.App.request.UserUpdateRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public User saveUser(UserRegistrationRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());

        return userRepository.save(user);
    }

    public AuthenticationResponse userLogin(AuthenticationRequest authenticationRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
            User user = userRepository.findByUsername(authenticationRequest.getUsername());
            String token = jwtService.generateToken(user);
            System.out.println("Login successful");
            return  AuthenticationResponse.builder().token(token).build();

        } catch (Exception e){
            System.out.println("Login error: " + e.getMessage());
            return null;
        }
            }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(int id){
        return userRepository.findById(id).get();
    }
    public User updateUser(int id, UserUpdateRequest updateRequest){
        User toUpdate = new User();
        toUpdate.setUsername(updateRequest.getUsername());
        toUpdate.setPassword(updateRequest.getPassword());
        toUpdate.setRole(updateRequest.getRole());
        return userRepository.save(toUpdate);

    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
