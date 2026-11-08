package edu.bellevue.cis530.studentservice.dto;

import edu.bellevue.cis530.studentservice.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithProfileResponse {
    private Student student;
    private StudentProfileDto profile;
}
