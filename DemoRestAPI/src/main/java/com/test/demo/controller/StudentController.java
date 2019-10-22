package com.test.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.security.Principal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.model.Student;
import com.test.demo.service.StudentService;

@RestController
@RequestMapping(value = "/api/",  produces = APPLICATION_JSON_VALUE)
public class StudentController {
	Logger logger = Logger.getLogger(StudentController.class.getName());
	
	@Autowired
	@Qualifier("v1")
	StudentService studentserviceV1;

	@Autowired
	@Qualifier("v2")
	StudentService studentserviceV2;

	@RequestMapping(value = "/v1/students", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Student> studentV1(Principal principal) {
		logger.info("Principal::"+principal.getName());
		return studentserviceV1.findAll();
	}
	
	@RequestMapping(value = "/v1/student", method = RequestMethod.POST, consumes =APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public Student saveStudentV1(@RequestBody Student student) {
		return studentserviceV1.save(student);
	}
	

	@RequestMapping(value = "/v2/student", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Student> studentV2() {
		return studentserviceV2.findAll();
	}
	
}
