package com.example.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.controller.dao.AlienJpaRepo;
import com.example.controller.dao.AlienRepo;
import com.example.controller.model.Alien;



@Controller
public class AlienController {
	@Autowired
	AlienRepo alienRepo;
	@Autowired
	AlienJpaRepo alienJpaRepo;

	@RequestMapping("/")
	public String getHome() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienRepo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int  aid) {
		ModelAndView mView=new ModelAndView("showAlien.jsp");
		Alien alien=alienRepo.findById(aid).orElse(new Alien());
		mView.addObject(alien);
		System.out.println(alienRepo.findByAidGreaterThan(aid));
		System.out.println(alienRepo.findByAidSorted(aid));
		return mView;
	}
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		return alienJpaRepo.findAll();
		
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") int  aid) {
		return alienJpaRepo.findById(aid);
		
	}

}
