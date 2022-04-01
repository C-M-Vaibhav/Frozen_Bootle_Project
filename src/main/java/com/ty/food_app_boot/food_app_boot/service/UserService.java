package com.ty.food_app_boot.food_app_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app_boot.food_app_boot.Exception.NoIdFoundException;
import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dao.UserDao;
import com.ty.food_app_boot.food_app_boot.dto.Items;
import com.ty.food_app_boot.food_app_boot.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public ResponseStruture<User> saveUser(User user) {
		User u = dao.saveUser(user);
		if(u==null) {
			throw new NoIdFoundException("User is not saved");
		}
		ResponseStruture<User> struture = new  ResponseStruture<User>();
		struture.setData(u);
		struture.setMsg("Saved User");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<User> updateUser(int id,User user) {
		User u =dao.update(id, user);
		if(u==null) {
			throw new NoIdFoundException("User Id is wrong");
		}
		ResponseStruture<User> struture = new  ResponseStruture<User>();
		struture.setData(u);
		struture.setMsg("Updated User");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Boolean> deleteUser(int id) {
		boolean b = dao.deletebyId(id);
		if(b==false) {
			throw new NoIdFoundException("User Id id wrong");
		}
		ResponseStruture<Boolean> struture = new  ResponseStruture<Boolean>();
		struture.setData(b);
		struture.setMsg("deleted User");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<List<User>> allUsers(){
		List<User> list = dao.getalluser();
		if(list.isEmpty()) {
			throw new NoIdFoundException("users are empty");
		}
		ResponseStruture<List<User>> struture = new  ResponseStruture<List<User>>();
		struture.setData(list);
		struture.setMsg("got all Users");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<User> getUserById(int id) {
		User user = dao.getUserById(id);
		if(user == null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<User> struture = new  ResponseStruture<User>();
		struture.setData(user);
		struture.setMsg("got Users");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}

}
