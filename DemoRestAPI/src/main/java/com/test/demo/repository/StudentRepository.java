package com.test.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {


}
