package com.test.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.model.Car;
@Repository
public interface CarRepository extends MongoRepository<Car, String> {


}
