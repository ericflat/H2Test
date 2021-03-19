package com.example.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue
	Long id;
	String username;
	String firstname;
	String lastname;
}
