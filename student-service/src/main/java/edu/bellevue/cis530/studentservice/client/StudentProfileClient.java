package edu.bellevue.cis530.studentservice.client;

import edu.bellevue.cis530.studentservice.dto.StudentProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-profile-service")
public interface StudentProfileClient {

    @GetMapping("/api/profiles/student/{studentId}")
    StudentProfileDto getProfileByStudentId(@PathVariable Long studentId);
}
