package com.fundamentos.platzi.fundamentos;
//https://start.spring.io/
//https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-spring-beans-and-dependency-injection.html
//https://spring.io/projects/spring-boot
//https://www.oracle.com/java/technologies/downloads/#java11
//https://github.com/joselugb/fundamentos-spring-boot/tree/main/src
//https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql.jpa-and-spring-data
import com.fundamentos.platzi.fundamentos.bean.MyBean;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithDependecy;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.component.ComponentDependency;
import com.fundamentos.platzi.fundamentos.pojo.UserPojo;
import com.fundamentos.platzi.fundamentos.repository.UserRepository;
import org.apache.catalina.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
    private MyBeanWithDependecy myBeanWithDependecy;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependecy myBeanWithDependecy,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
        this.myBeanWithDependecy = myBeanWithDependecy;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();

	}
	private void getInformationJpqlFromUser(){
		LOGGER.info("\n Usuario con el metodo findByUserEmail: " +
				userRepository.findByUserMail("jose@gmail.com")
				.orElseThrow(()-> new RuntimeException("\n NO se encontro el mail")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("\n Usuario con metodo sort" + user));

		userRepository.findByName("Omar")
				.stream()
				.forEach(user -> LOGGER.info("\n Usuario con query method: "+ user));

		LOGGER.info("\nUsuario con findByEmailAndName: " + userRepository.findByEmailAndName("david@gmail.com","David")
				.orElseThrow(() -> new RuntimeException("\nUsuario no encontrado")));

		userRepository.findByNameLike("%user%")
				.stream()
				.forEach(user -> LOGGER.info("\nUsuario de findByNameLike " + user));

        LOGGER.info( "\nEl usuario a partir del named parameter es: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022,01,13),
                "jose@gmail.com")
                .orElseThrow(() ->
                    new RuntimeException("\nNO se encontro el usuario a partir del named parameter")));

	}
	private void saveUsersInDataBase(){
		com.fundamentos.platzi.fundamentos.entity.User user1 = new com.fundamentos.platzi.fundamentos.entity.User("John","john@gmail.com", LocalDate.of(2022,02,12));
		com.fundamentos.platzi.fundamentos.entity.User user2 = new com.fundamentos.platzi.fundamentos.entity.User("Jose","jose@gmail.com", LocalDate.of(2022,01,13));
		com.fundamentos.platzi.fundamentos.entity.User user3 = new com.fundamentos.platzi.fundamentos.entity.User("user3","manuel@gmail.com", LocalDate.of(2022,02,14));
		com.fundamentos.platzi.fundamentos.entity.User user4 = new com.fundamentos.platzi.fundamentos.entity.User("Pepito","pepito@gmail.com", LocalDate.of(2022,01,15));
		com.fundamentos.platzi.fundamentos.entity.User user5 = new com.fundamentos.platzi.fundamentos.entity.User("Dylan","dylan@gmail.com", LocalDate.of(2022,02,10));
		com.fundamentos.platzi.fundamentos.entity.User user6 = new com.fundamentos.platzi.fundamentos.entity.User("David","david@gmail.com", LocalDate.of(2022,01,11));
		com.fundamentos.platzi.fundamentos.entity.User user7 = new com.fundamentos.platzi.fundamentos.entity.User("user7","vanessa@gmail.com", LocalDate.of(2022,02,05));
		com.fundamentos.platzi.fundamentos.entity.User user8 = new com.fundamentos.platzi.fundamentos.entity.User("Nayely","nayely@gmail.com", LocalDate.of(2022,01,07));
		com.fundamentos.platzi.fundamentos.entity.User user9 = new com.fundamentos.platzi.fundamentos.entity.User("Omar","omar@gmail.com", LocalDate.of(2022,02,07));
		com.fundamentos.platzi.fundamentos.entity.User user10 = new com.fundamentos.platzi.fundamentos.entity.User("user10","carlos@gmail.com", LocalDate.of(2022,01,06));
		List<com.fundamentos.platzi.fundamentos.entity.User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		list.stream().forEach(userRepository::save);
	}
	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependecy.printWithDependecy();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		try{
			//error
			int values = 10 / 0;
			LOGGER.debug("Mi valor es: " + values);
		}
		catch(Exception ex){
			LOGGER.error("Esto es lo que pasa dividir un numero para cero, "+ ex.getMessage());

		}

		LOGGER.error("ESTO es un ERROR del aplicativo");
	}
}
