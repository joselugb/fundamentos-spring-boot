package com.fundamentos.platzi.fundamentos.caseuse;

import com.fundamentos.platzi.fundamentos.entity.User;
import com.fundamentos.platzi.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
