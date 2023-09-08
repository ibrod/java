package Practice4;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<Student>();
        Student student1=new Student("张三");
        student1.addCourse("语文", 80);
        student1.addCourse("数学", 90);
        student1.addCourse("英语", 70);

        Student student2=new Student("李四");
        student2.addCourse("语文", 85);
        student2.addCourse("数学", 95);

        Student student3=new Student("王五");
        student3.addCourse("语文", 75);
        student3.addCourse("数学", 80);
        student3.addCourse("英语", 60);
        student3.addCourse("理综", 250);

        list.add(student1);
        list.add(student2);
        list.add(student3);

        for(Student student:list){
            for(int i=0;i<student.getCourses().size();i++){
                System.out.println(student.getName()+"的"+student.getCoursesName().get(i)+"成绩为"+student.getCourses().get(i));
            }
        }

    }
}
