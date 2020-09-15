package com.staxter.userrepository;

import com.staxter.exception.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository{

    Map<String, User> userMap = new HashMap<>();

    @Override
    public User createUser(User user) throws UserAlreadyExistsException {
        if(userMap.isEmpty()){
            userMap.put(user.getUserName(),user);
        }else{
            for(String userName : userMap.keySet()) {
                if (user.getUserName().equals(userName)) {
                    throw new UserAlreadyExistsException("USER_ALREADY_EXISTS", "A user with given username already exists");
                } else {
                    userMap.put(user.getUserName(), user);

                }
            }
        }
        return user;
    }

    @Override
    public List<User> getAllUsers(){
        return userMap.values().stream()
                .collect(Collectors.toList());
    }
}
