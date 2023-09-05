package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.dto.Users_dto;
import com.Share_Sense.bill_splitting.entities.User;
import com.Share_Sense.bill_splitting.globalException.BusinessException;
import com.Share_Sense.bill_splitting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;

	@Autowired
	private ModelMapper modelmapper;

	// get all users
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	// get users by id
	public User getUserById(Long id) {
		if (id < 1) {
			throw new BusinessException("enter +ve value");
		}
		Optional<User> userOptional = userrepo.findById(id);
		User user = userOptional.get();
		return user;
	}

	// create users
	public User createUser(Users_dto user1) {

		User user = modelmapper.map(user1, User.class);

		return user;
	}

	// delete users by id
	public boolean deleteUser(Long id) {
		userrepo.deleteById(id);
		return false;

	}

}
