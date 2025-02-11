package day1_generics.airesumescreening;

public class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public String requiredSkills() {
        return "Required Skills: Python, SQL, Machine Learning, Statistics";
    }
}