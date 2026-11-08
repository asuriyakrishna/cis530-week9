package edu.bellevue.cis530.studentservice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileDto {
    private Long id;
    private Long studentId;
    private String major;
    private BigDecimal gpa;
    private String bio;
}
