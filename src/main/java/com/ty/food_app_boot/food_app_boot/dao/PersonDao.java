package com.ty.food_app_boot.food_app_boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app_boot.food_app_boot.dto.Person;
import com.ty.food_app_boot.food_app_boot.repostary.PersonRepositary;

@Repository
public class PersonDao {

	@Autowired
	PersonRepositary repositary;

	public Person savePerson(Person person) {
		return repositary.save(person);
	}

	public Person getPersonById(int id) {
		Optional<Person> optional = repositary.findById(id);
		if (optional != null) {
			return optional.get();
		}
		return null;
	}

	public Person updatePersonById(int id, Person person) {
		Person p = getPersonById(id);
		if (p != null) {
			return repositary.save(person);
		}
		return null;
	}

	public boolean deletePersonById(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			repositary.delete(person);
			return true;
		}
		return false;
	}

	public List<Person> allPersons() {
		return repositary.findAll();
	}

}
