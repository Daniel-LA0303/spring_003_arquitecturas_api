package com.mx.graphql.students.persistence;

import org.springframework.data.repository.CrudRepository;

import com.mx.graphql.students.entities.Student;

public interface IStudentDAO extends CrudRepository<Student, Long> {
}
