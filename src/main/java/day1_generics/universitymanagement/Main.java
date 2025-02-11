package day1_generics.universitymanagement;

public class Main {
    public static void main(String[] args) {
        // creating course catalog
        CourseCatalog catalog = new CourseCatalog();

        // creating courses
        Course<ExamCourse> scienceCourse = new Course<>(new ExamCourse("Science", "Mr. Aloney", 60));
        Course<AssignmentCourse> computerCourse = new Course<>(new AssignmentCourse("Computer Science", "Prof Rajesh Bhogey", 4));
        Course<ResearchCourse> aiCourse = new Course<>(new ResearchCourse("Artificial Intelligence", "Prof Anjali Tiwari", "Deep Learning"));

        // adding courses to catalog
        catalog.addCourse(scienceCourse);
        catalog.addCourse(computerCourse);
        catalog.addCourse(aiCourse);

        // displaying list of courses
        catalog.displayCourses();
    }
}
