package day1_generics.universitymanagement;

public abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract <T> T getCourseDetail();

    @Override
    public String toString(){
        return "Course : " + courseName + "\nInstructor : " + instructor + "\nDetails : " + getCourseDetail();
    }
}
