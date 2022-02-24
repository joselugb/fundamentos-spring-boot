package com.fundamentos.platzi.fundamentos.caseuse;

import com.fundamentos.platzi.fundamentos.entity.User;
import com.fundamentos.platzi.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    public User update(User newUser, Long id) {
        return userService.update(newUser,id);
    }
}
