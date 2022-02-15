package com.fundamentos.platzi.fundamentos.bean;

public class MyBeanWithDependecyImplement implements MyBeanWithDependecy{
    private MyOperation myOperation;

    public MyBeanWithDependecyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependecy() {
        System.out.println(myOperation.suma(1));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
