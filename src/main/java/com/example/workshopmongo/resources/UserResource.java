package com.example.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	//@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User maria = new User("123","Maria Brown","maria@gmail.com");
		User alex = new User("124","Alex Green","alex@gmail.com");
		User joao = new User("125","João Purple","joao@gmail.com");
		list.addAll(Arrays.asList(maria,alex,joao));
		return ResponseEntity.ok().body(list);
		
	}
}
