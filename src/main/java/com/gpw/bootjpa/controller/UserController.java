package com.gpw.bootjpa.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpw.bootjpa.dao.UserDao;
import com.gpw.bootjpa.model.Module;
import com.gpw.bootjpa.model.User;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserDao dao;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return (List<User>) dao.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId){
		return ResponseEntity.ok().body(dao.findById(userId).orElse(null));
	}
	
	@GetMapping("/users/{id}/modules")
	public ResponseEntity<Map<String, Set<Module>>> getModulesByUserId(@PathVariable(value = "id") Long userId){
		User user = dao.findById(userId).orElse(null);
		Map<String, Set<Module>> response = new HashMap<String, Set<Module>>();
		response.put("modules", user==null?null:user.getModules());
		return ResponseEntity.ok().body(response);
	}

}
