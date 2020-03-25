package com.sv.restapi.lab1.service;

import com.sv.restapi.lab1.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesHardcodedService {

    private static List<Course> courses = new ArrayList<>();
    private static long idCounter = 0;
    static {
        courses.add(new Course(++idCounter, "svcs", "Learn Full stack with Spring Boot and Angular"));
        courses.add(new Course(++idCounter, "svcs", "Learn Full stack with Spring Boot and React"));
        courses.add(new Course(++idCounter, "svcs", "Master Microservices with Spring Boot and Spring Cloud"));
        courses.add(new Course(++idCounter, "svcs",
                "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"));
    }
    public List<Course> findAll() {
        return courses;
    }
}
