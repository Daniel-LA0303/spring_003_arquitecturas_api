package com.mx.graphql.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mx.graphql.students.entities.Course;
import com.mx.graphql.students.entities.Student;
import com.mx.graphql.students.graphql.InputStudent;
import com.mx.graphql.students.service.ICourseService;
import com.mx.graphql.students.service.IStudentService;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class GraphQLStudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id){
        Long studentId = Long.parseLong(id);

        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent){

        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.createStudent(student);

        return student;
    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name = "studentId") String id){
        studentService.deleteById(Long.parseLong(id));
        return "El estudiante con id " + id + " ha sido eliminado.";
    }
}