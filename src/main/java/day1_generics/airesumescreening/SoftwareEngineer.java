package day1_generics.airesumescreening;

public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public String requiredSkills() {
        return "Required Skills: Java, Python, Data Structures, Algorithms";
    }
}