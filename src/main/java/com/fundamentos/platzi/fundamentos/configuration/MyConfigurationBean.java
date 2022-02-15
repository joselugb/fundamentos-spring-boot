package com.fundamentos.platzi.fundamentos.configuration;

import com.fundamentos.platzi.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }
    @Bean
    public MyBeanWithDependecy beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependecyImplement(myOperation);
    }
}
