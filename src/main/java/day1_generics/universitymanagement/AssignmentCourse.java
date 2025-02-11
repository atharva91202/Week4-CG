package day1_generics.universitymanagement;

public class AssignmentCourse extends CourseType{
    public int totalAssignments;

    public AssignmentCourse(String courseName, String instructor, int totalAssignments) {
        super(courseName, instructor);
        this.totalAssignments = totalAssignments;
    }

    @Override
    public <T> T getCourseDetail() {
        return (T)("Total Assignments : " + totalAssignments);
    }
}
