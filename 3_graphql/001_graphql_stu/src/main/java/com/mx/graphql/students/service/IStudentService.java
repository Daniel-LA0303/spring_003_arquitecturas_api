package com.mx.graphql.students.service;

import java.util.List;

import com.mx.graphql.students.entities.Student;

public interface IStudentService {

    Student findById(Long id);

    List<Student> findAll();

    void createStudent(Student student);

    void deleteById(Long id);
}