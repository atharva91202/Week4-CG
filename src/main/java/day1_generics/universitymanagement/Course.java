package day1_generics.universitymanagement;

public class Course <T extends CourseType>{
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "CourseType : " + courseType;
    }
}
