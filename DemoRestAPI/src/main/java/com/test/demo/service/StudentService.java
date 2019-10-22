package com.test.demo.service;

import java.util.Optional;

import com.test.demo.model.Student;

public interface StudentService {

	public Iterable<Student> findAll();

	public Student save(Student student);

	public Optional<Student> findByID(String id);

	public void removeStudent(String id);

}
