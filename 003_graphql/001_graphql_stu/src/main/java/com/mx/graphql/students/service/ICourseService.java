package com.mx.graphql.students.service;

import java.util.List;

import com.mx.graphql.students.entities.Course;

public interface ICourseService {

    Course findById(Long id);

    List<Course> findAll();

    void createCourse(Course course);

    void deleteById(Long id);
}