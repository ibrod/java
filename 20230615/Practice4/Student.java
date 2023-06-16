package Practice4;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> courses;
    private List<String> coursesName;
    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<Double>();
        this.coursesName = new ArrayList<String>();
    }
    Student() {
        this.courses = new ArrayList<Double>();
        this.coursesName = new ArrayList<String>();
    }

    public void addCourse(String courseName, double score) {
        this.coursesName.add(courseName);
        this.courses.add(score);
    }

    public void removeCourse(String courseName) {
        int index = this.coursesName.indexOf(courseName);
        this.coursesName.remove(index);
        this.courses.remove(index);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public  List<Double> getCourses() {
        return courses;
    }
    public void setCourses(List<Double> courses) {
        this.courses = courses;
    }
    public List<String> getCoursesName() {
        return coursesName;
    }
    public void setCoursesName(List<String> coursesName) {
        this.coursesName = coursesName;
    }

    
    
}
