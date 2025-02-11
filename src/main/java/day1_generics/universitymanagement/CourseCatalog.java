package day1_generics.universitymanagement;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses(){
        System.out.println("List of Courses :-");
        for(Course<? extends CourseType> course : courses){
            System.out.println(course);
        }
    }
}