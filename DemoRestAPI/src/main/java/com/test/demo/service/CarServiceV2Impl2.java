package com.test.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.model.Car;
import com.test.demo.repository.CarRepository;

@Service("carv2")
public class CarServiceV2Impl2 implements CarService {
	
	@Autowired
	CarRepository carRepository;

	@Override
	public Iterable<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Car save(Car student) {
		return carRepository.save(student);
	}

	@Override
	public Optional<Car> findByID(String id) {
		return carRepository.findById(id);
	}

	@Override
	public void removeStudent(String id) {
    	Car st = new Car();
    	st.setId(id);
    	carRepository.delete(st);		
	}

}
