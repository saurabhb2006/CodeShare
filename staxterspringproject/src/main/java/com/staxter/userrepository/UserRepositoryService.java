package com.staxter.userrepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.staxter.UserRegistrationBean;
import com.staxter.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserRepositoryService {
    // Hashmap contains unique userName as keys and User object as values

    @Autowired
    private UserRepository userRepository;// = new UserRepositoryImpl();

    public User createUser(UserRegistrationBean userRegistrationBean){

        User user = new User(userRegistrationBean.getFirstName(), userRegistrationBean.getLastName(),
                userRegistrationBean.getUserName(), userRegistrationBean.getPassword());
        return userRepository.createUser(user);
    }


    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
}
