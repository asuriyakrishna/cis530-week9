package edu.bellevue.cis530.studentservice.controller;

import edu.bellevue.cis530.studentservice.client.StudentProfileClient;
import edu.bellevue.cis530.studentservice.dto.StudentProfileDto;
import edu.bellevue.cis530.studentservice.dto.StudentWithProfileResponse;
import edu.bellevue.cis530.studentservice.entity.Student;
import edu.bellevue.cis530.studentservice.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentProfileClient studentProfileClient;

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/{id}/full")
    public ResponseEntity<StudentWithProfileResponse> getStudentWithProfile(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        StudentProfileDto profile = null;
        try {
            profile = studentProfileClient.getProfileByStudentId(id);
        } catch (Exception ignored) {
            // Ignore missing profile; response may contain null profile.
        }
        return ResponseEntity.ok(new StudentWithProfileResponse(student, profile));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<StudentWithProfileResponse> getStudentDetails(@PathVariable Long id) {
        return getStudentWithProfile(id);
    }
}
