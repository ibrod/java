package course;

import java.util.*;

public class Stu {
    public String name;
    public int id;
    Course[] c = new Course[10];
    private int idx = 0;// 已选课程数量
    CourseSystem cs = new CourseSystem();

    
   public  void listc() {
        System.out.println("目前有下面这些课程:");
        cs.show_course();
    }

    public  void choose_course(int cid) {
        System.out.println("你选择的课程是" + cs.c[cid - 1000].name + ",选课成功");
        c[idx] = new Course(cs.c[cid - 1000].name, cs.c[cid - 1000].id, cs.c[cid - 1000].score);
    }

    public void exam(int cid) {
        cs.c[cid - 1000].grades = Exam.getGrades();
        System.out.println("考试完成，您的" + cs.c[cid - 1000].name + "课程分数为:" + cs.c[cid - 1000].grades);
    }

    public void check(int cid) {
        if (cs.c[cid - 1000].grades != 0) {
            System.out.println("您的" + cs.c[cid - 1000].name + "课程分数为:" + cs.c[cid - 1000].grades);
        }else{
            System.out.println("您尚未参加该门课程的考试，无法查询该门课的成绩");
        }
    }



}