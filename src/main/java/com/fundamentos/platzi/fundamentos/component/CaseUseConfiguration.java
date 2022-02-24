package com.fundamentos.platzi.fundamentos.component;

import com.fundamentos.platzi.fundamentos.caseuse.GetUser;
import com.fundamentos.platzi.fundamentos.caseuse.GetUserImplement;
import com.fundamentos.platzi.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
