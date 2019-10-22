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

import com.test.demo.model.Car;
import com.test.demo.service.CarService;

@RestController
@RequestMapping(value = "/api/",  produces = APPLICATION_JSON_VALUE)
public class CarController {
	Logger logger = Logger.getLogger(CarController.class.getName());
	
	@Autowired
	@Qualifier("carv1")
	CarService carserviceV1;

	@Autowired
	@Qualifier("carv2")
	CarService carserviceV2;

	@RequestMapping(value = "/v1/cars", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Car> studentV1(Principal principal) {
		logger.info("Principal::"+principal.getName());
		return carserviceV1.findAll();
	}
	
	@RequestMapping(value = "/v1/car", method = RequestMethod.POST, consumes =APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public Car saveStudentV1(@RequestBody Car student) {
		return carserviceV1.save(student);
	}
	

	@RequestMapping(value = "/v2/car", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Car> studentV2() {
		return carserviceV2.findAll();
	}
	
}
