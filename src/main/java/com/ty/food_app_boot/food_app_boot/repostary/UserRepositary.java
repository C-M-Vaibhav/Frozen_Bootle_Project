package com.ty.food_app_boot.food_app_boot.repostary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app_boot.food_app_boot.dto.User;

public interface UserRepositary extends JpaRepository<User, Integer> {

}
