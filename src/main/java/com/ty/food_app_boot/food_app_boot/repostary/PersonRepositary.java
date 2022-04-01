package com.ty.food_app_boot.food_app_boot.repostary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app_boot.food_app_boot.dto.Person;

public interface PersonRepositary extends JpaRepository<Person, Integer> {

}
