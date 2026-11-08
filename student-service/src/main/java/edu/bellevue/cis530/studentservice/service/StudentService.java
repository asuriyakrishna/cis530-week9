package edu.bellevue.cis530.studentservice.service;

import edu.bellevue.cis530.studentservice.entity.Student;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void deleteStudent(Long id);
}
