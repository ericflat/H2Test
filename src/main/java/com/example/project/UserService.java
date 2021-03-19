package com.example.project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	UsersRepository userRepository;

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<Users> getUserByID(Long id) {
		return userRepository.findById(id);
	}

	public Users createUser(Users user) {
		return userRepository.save(user);
	}

	public Boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}

	public List<Users> findUserByLastName(String lastname) {
		List<Users> usersWithLastName = userRepository.findAll().stream()
				.filter(user -> user.getLastname().equals(lastname)).collect(Collectors.toList());
		return usersWithLastName;
	}
	}