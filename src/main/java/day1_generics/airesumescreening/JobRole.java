package day1_generics.airesumescreening;

public abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // Abstract method related to generics
    public abstract String requiredSkills();

    @Override
    public String toString() {
        return candidateName + " - " + experienceYears + " years of experience";
    }
}