package com.example.controller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controller.model.Alien;

public interface AlienJpaRepo extends JpaRepository<Alien, Integer>{

}
