package com.kgfsl.springdata1.controller;

//
import java.util.List;

import com.kgfsl.springdata1.model.Student;
import com.kgfsl.springdata1.repository.*;

//import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





/**
 * StudentController

 */
@RestController
 

public class StudentController{
    @Autowired
    StudentRepository studentRepository;

	@RequestMapping("/")
	public ModelAndView hello () throws Exception {
		List<Student> listUsers = studentRepository.findAll();
		ModelAndView model = new ModelAndView("Userlist");
		model.addObject("userList", listUsers);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView add (@RequestBody Student adds,@PathVariable Long id) throws Exception {
		adds.setId(id);
		studentRepository.saveAndFlush(adds);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new Student());
		return model;
	}

	
	// @RequestMapping(value = "/new", method = RequestMethod.GET)
	// public ModelAndView newStudent() {
	// 	ModelAndView model = new ModelAndView("UserForm");
	// 	model.addObject("user", new Student());
	// 	return model;		
	// }

}