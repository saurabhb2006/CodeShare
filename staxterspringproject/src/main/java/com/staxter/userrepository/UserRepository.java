package com.staxter.userrepository;

import java.util.List;
import com.staxter.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User createUser(User user) throws UserAlreadyExistsException;

    List<User> getAllUsers();
}
