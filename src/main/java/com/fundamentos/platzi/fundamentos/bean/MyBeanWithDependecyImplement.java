package com.fundamentos.platzi.fundamentos.bean;

import com.fundamentos.platzi.fundamentos.FundamentosApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Slf4j
public class MyBeanWithDependecyImplement implements MyBeanWithDependecy{
    private MyOperation myOperation;
    Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    public MyBeanWithDependecyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
        log.info("Entrando al método Constructor MyBeanWithDependecyImplement");
    }

    @Override
    public void printWithDependecy() {
        LOGGER.info("Entrando al método printWithDependecy");
        int numero = 1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operation es: "+numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
        log.info("Saliendo al método printWithDependecy");
    }
}
