package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //essa anotação diz que essa classe é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/users") //essa anotação é o nome do recurso
public class UserResource {
	
	//método que é um endpoint pra acessar os usuários
	// o tipo de retorno ResponseEntity é pra retornar respostas de requisições web
	@GetMapping  //ess anotação indica que esse método abaixo responde à requisição tipo get do http
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u); //.ok() retorna resposta com sucesso do http, .body(u) retorna no corpo da resposta o usuário u q acabei de instanciar
	}
}
