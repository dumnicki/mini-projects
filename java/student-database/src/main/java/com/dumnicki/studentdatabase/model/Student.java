package com.dumnicki.studentdatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    private List<Course> courseList;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String email, List<Course> courseList) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseList = courseList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public boolean enrolledInCourse(Course course) {
        return  courseList.stream().anyMatch(containedCourse->containedCourse.getId()==course.getId());
    }
}
