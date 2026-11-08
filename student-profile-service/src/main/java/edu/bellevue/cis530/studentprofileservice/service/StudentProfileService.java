package edu.bellevue.cis530.studentprofileservice.service;

import edu.bellevue.cis530.studentprofileservice.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createProfile(StudentProfile profile);

    List<StudentProfile> getAllProfiles();

    StudentProfile getProfileById(Long id);

    StudentProfile getProfileByStudentId(Long studentId);

    void deleteProfile(Long id);
}
