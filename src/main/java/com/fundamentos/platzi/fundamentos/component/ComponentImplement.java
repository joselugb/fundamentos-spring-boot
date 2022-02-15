package com.fundamentos.platzi.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("HOla MUNDO desde mi componente");

    }
}
