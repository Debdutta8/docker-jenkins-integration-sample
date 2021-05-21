package com.example.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.controller.model.Alien;



public interface AlienRepo extends CrudRepository<Alien, Integer>{
	 List<Alien> findByAname(String aname);
	 List<Alien> findByAidGreaterThan(int aid);
	 @Query("from Alien where aid>?1 order by aname desc")
	 List<Alien> findByAidSorted(int aid);

}
