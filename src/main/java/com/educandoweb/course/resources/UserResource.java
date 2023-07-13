package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // essa anotação diz que essa classe é um recurso web que é implementado por um controlador rest
@RequestMapping(value = "/users") //o q vai entre aspas é usado no navegador com localhost:8080 para o postman
public class UserResource {

	@Autowired
	private UserService service;

	// método que é um endpoint pra acessar os usuários
	// o tipo de retorno ResponseEntity é pra retornar respostas de requisições web
	@GetMapping  //ess anotação indica que esse método abaixo responde à requisição tipo get do http
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok() retorna resposta com sucesso do http, .body(u) retorna no corpo da resposta o usuário u q acabei de instanciar
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
