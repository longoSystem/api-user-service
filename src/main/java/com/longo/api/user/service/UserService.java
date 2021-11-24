package com.longo.api.user.service;

/**
 * Camada de servicos realizados para fornecer os recursos da API. 
 * 
 * @author longo.juliano
 */

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.longo.api.user.model.User;

@Service
public class UserService {

	private List<User> list = new ArrayList<>();
	
	/**
	 * Servico responsavel por criar uma lista de usuarios.
	 * 
	 * @return
	 */
	public List<User> findAllUsersFakeService() {
		
		DateTimeFormatter formatterPtBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		User u1 = User.builder()
				.id((long) 1)
				.firstName("Juliano")
				.lastName("Longo")
				.birthDate(LocalDate.of(1978, Month.MAY, 2).format(formatterPtBr))
				.build();
		list.add(u1);
		
		User u2 = User.builder()
				.id((long) 2)
				.firstName("Larissa")
				.lastName("Longo")
				.birthDate(LocalDate.of(1989, Month.OCTOBER, 27).format(formatterPtBr))
				.build();
		list.add(u2);
		
		User u3 = User.builder()
				.id((long) 3)
				.firstName("Matheus")
				.lastName("Longo")
				.birthDate(LocalDate.of(2000, Month.FEBRUARY, 2).format(formatterPtBr))
				.build();
		list.add(u3);
		
		return list;
	}
	
	/**
	 * Servico responsavel por retornar um usuario a partir do ID.
	 * 
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		try {
			findAllUsersFakeService(); //popula a lista de users
			for (User user : list) {
				if (user.getId().equals(new Long(id))) {
					return user;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}
