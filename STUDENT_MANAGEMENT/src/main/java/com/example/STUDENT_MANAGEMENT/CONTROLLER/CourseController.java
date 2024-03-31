package com.example.STUDENT_MANAGEMENT.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.STUDENT_MANAGEMENT.ENTITY.Course;
import com.example.STUDENT_MANAGEMENT.MODEL.*;
import com.example.STUDENT_MANAGEMENT.SERVICE.*;

import java.util.List;

@Controller
public class CourseController {
	
@Autowired
CourseService courseservice;

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> courses = courseservice.getAll();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/courses/add")
    public String showAddCourseForm(Course course) {
        return "add-course";
    }

    @PostMapping("/courses/add")
    public String addCourse(Course course) {
    	courseservice.saveAll(course);
        return "redirect:/courses";
    }
}