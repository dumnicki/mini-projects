package com.dumnicki.studentdatabase.repository;

import com.dumnicki.studentdatabase.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public List<Course> findByLabel(String label);
}
