package day1_generics.airesumescreening;

import java.util.ArrayList;
import java.util.List;

public class ResumeProcessor {
    private List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        if (validateResume(resume)) {
            resumeList.add(resume);
        } else {
            System.out.println("Invalid resume: " + resume);
        }
    }

    // Generic method for validation
    public <T extends JobRole> boolean validateResume(Resume<T> resume) {
        return resume.getJobRole().getExperienceYears() >= 1; // Ensure at least 1 year experience
    }

    public void displayResumes() {
        System.out.println("Processed Resumes:");
        for (Resume<? extends JobRole> resume : resumeList) {
            System.out.println(resume);
        }
    }
}