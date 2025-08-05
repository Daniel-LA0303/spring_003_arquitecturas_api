package com.mx.graphql.students.persistence;

import org.springframework.data.repository.CrudRepository;

import com.mx.graphql.students.entities.Course;

public interface ICourseDAO extends CrudRepository<Course, Long> {
}
