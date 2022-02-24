package com.fundamentos.platzi.fundamentos.caseuse;

import com.fundamentos.platzi.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    public void remove(Long id) {
        userService.delete(id);
    }
}
