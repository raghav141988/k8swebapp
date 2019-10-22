package com.test.demo.service;

import java.util.Optional;

import com.test.demo.model.Car;

public interface CarService {

	public Iterable<Car> findAll();

	public Car save(Car student);

	public Optional<Car> findByID(String id);

	public void removeStudent(String id);

}
