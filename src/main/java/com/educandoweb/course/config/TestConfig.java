package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration //essa classe é uma classe de configuração
@Profile("test") // essa classe é de configuração específica do perfil de teste, o teste que foi definido no application.properties
public class TestConfig implements CommandLineRunner{
	
	//Aqui faço a injeção de dependencia. Uso a anotação @Autowired
	@Autowired
	private UserRepository userRepository;

	@Override //Tudo que for colocado nesse método vai ser executado quando a aplicação for iniciada
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	

}
