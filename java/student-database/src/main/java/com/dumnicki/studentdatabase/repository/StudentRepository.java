package com.dumnicki.studentdatabase.repository;

import com.dumnicki.studentdatabase.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
