package com.longo.api.user.resource;

/**
 * Expõe os servicos fornecidos pela API.
 * 
 * @author longo.juliano
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.longo.api.user.model.User;
import com.longo.api.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserResource {


	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> findAll() {
		log.info("method: UserServicesResource.findAll");
		try {
			return ResponseEntity.ok(userService.findAllUsersFakeService());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		log.info("method: UserServicesResource.findAll");
		try {
			User user = userService.findById(id.intValue());
			return ResponseEntity.ok((user != null ? user : "User Not Found!"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
