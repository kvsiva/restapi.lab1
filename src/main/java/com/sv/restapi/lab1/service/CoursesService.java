package com.sv.restapi.lab1.service;

import com.sv.restapi.lab1.dao.CourseDAO;
import com.sv.restapi.lab1.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CourseDAO courseDAO;

    public Course save(Course course) {

        courseDAO.addCourse(course);

        return course;
    }

    public List<Course> findAll(String username) {
        return courseDAO.getCourses(username);
    }

    public Course deleteById(long id) {
        return null;
    }

    public Course findById(long id) {
        return null;
    }
}
