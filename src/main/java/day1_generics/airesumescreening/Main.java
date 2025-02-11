package day1_generics.airesumescreening;

public class Main {
    public static void main(String[] args) {
        // Creating resume processor
        ResumeProcessor processor = new ResumeProcessor();

        // Creating different resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 5));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 3));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 7));
        Resume<SoftwareEngineer> fresherResume = new Resume<>(new SoftwareEngineer("David", 0)); // Should not be added

        // Adding resumes to the processor
        processor.addResume(seResume);
        processor.addResume(dsResume);
        processor.addResume(pmResume);
        processor.addResume(fresherResume);

        // Display resumes
        processor.displayResumes();
    }
}