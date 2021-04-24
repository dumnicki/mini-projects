package com.dumnicki.studentdatabase.controller;

import com.dumnicki.studentdatabase.model.Course;
import com.dumnicki.studentdatabase.model.Student;
import com.dumnicki.studentdatabase.repository.CourseRepository;
import com.dumnicki.studentdatabase.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/student/{id}")
    public String student(@PathVariable Long id, Model model) {
        model.addAttribute("student",repository.findById(id).get());
        model.addAttribute("courseList",courseRepository.findAll());
        return "student";
    }

    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("studentList",repository.findAll());
        return "studentList";
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, Model model) {
        Student student = new Student();
        student.setEmail(email);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        repository.save(student);

        model.addAttribute("student",student);
        model.addAttribute("courseList",courseRepository.findAll());
        return "redirect:/student/" + student.getId();
    }

    @PostMapping("/student/{id}/courses")
    public String addCourseForStudent(@PathVariable Long id, @RequestParam Long courseId, Model model) {
        Course course = courseRepository.findById(courseId).get();
        Student student = repository.findById(id).get();

        if(student != null) {
            if(!student.enrolledInCourse(course)) {
                student.getCourseList().add(course);
            }
            repository.save(student);
            model.addAttribute("student", repository.findById(id).get());
            model.addAttribute("courseList", courseRepository.findAll());
            return "redirect:/student/" + student.getId();
        }
        model.addAttribute("studentList",repository.findAll());
        return "redirect:/students";
    }

}
