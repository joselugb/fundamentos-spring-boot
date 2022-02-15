package com.fundamentos.platzi.fundamentos;

import com.fundamentos.platzi.fundamentos.bean.MyBean;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithDependecy;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private ComponentDependency componentDependency;
	private MyBean myBean;
    private MyBeanWithDependecy myBeanWithDependecy;
	private MyBeanWithProperties myBeanWithProperties;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependecy myBeanWithDependecy, MyBeanWithProperties myBeanWithProperties){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
        this.myBeanWithDependecy = myBeanWithDependecy;
		this.myBeanWithProperties = myBeanWithProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
        myBeanWithDependecy.printWithDependecy();
		//System.out.println(myBeanWithProperties.function());

	}
}
