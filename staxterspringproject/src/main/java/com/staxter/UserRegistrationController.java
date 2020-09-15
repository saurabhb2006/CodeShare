package com.staxter;


import com.staxter.exception.UserAlreadyExistsException;
import com.staxter.userrepository.User;
import com.staxter.userrepository.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userservice")
public class UserRegistrationController {

    @Autowired(required = true)
    private UserRepositoryService userRepositoryService;

    @RequestMapping(method = RequestMethod.POST, value="/register")
    @ResponseBody
    public ResponseEntity<Object> registerUser(@RequestBody UserRegistrationBean userRegistrationBean) {
        User user = null;
        try {
       /*     user = userRepositoryService.createUser(new User(inputUser.getFirstName(), inputUser.getLastName(),
                    inputUser.getUserName(), inputUser.getPassword()));*/
            user = userRepositoryService.createUser(userRegistrationBean);
        }
          catch (UserAlreadyExistsException userAlreadyExistsException) {
            throw userAlreadyExistsException;
        }

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value="/users")
    @ResponseBody
    public ResponseEntity<Object> allUsers() {
        List<User> userList = userRepositoryService.getAllUsers();
        return new ResponseEntity(userList, HttpStatus.OK);
    }
}
