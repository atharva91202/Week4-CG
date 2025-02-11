package day1_generics.universitymanagement;

public class ExamCourse extends CourseType{
    private int examWeightage;

    public ExamCourse(String courseName, String instructor, int examWeightage) {
        super(courseName, instructor);
        this.examWeightage = examWeightage;
    }

    @Override
    public <T> T getCourseDetail(){
        return (T) ("Exam Weightage : " + examWeightage);
    }
}
