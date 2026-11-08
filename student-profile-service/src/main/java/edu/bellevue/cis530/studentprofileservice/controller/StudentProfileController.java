package edu.bellevue.cis530.studentprofileservice.controller;

import edu.bellevue.cis530.studentprofileservice.entity.StudentProfile;
import edu.bellevue.cis530.studentprofileservice.service.StudentProfileService;
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
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @PostMapping
    public ResponseEntity<StudentProfile> createProfile(@Valid @RequestBody StudentProfile profile) {
        return new ResponseEntity<>(studentProfileService.createProfile(profile), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllProfiles() {
        return ResponseEntity.ok(studentProfileService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(studentProfileService.getProfileById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentProfile> getProfileByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentProfileService.getProfileByStudentId(studentId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        studentProfileService.deleteProfile(id);
        return ResponseEntity.ok("Profile deleted successfully");
    }
}
