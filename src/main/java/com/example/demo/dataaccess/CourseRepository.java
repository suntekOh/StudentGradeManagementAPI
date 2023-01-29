package com.example.demo.dataaccess;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dataaccess.entities.Course;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CourseRepository extends CrudRepository<Course, UUID> {

}