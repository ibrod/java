package course;

public class CourseSystem {
    public Course[] c=new Course[7];
    
    CourseSystem(){
        c[1]=new Course("C","1001",2);
        c[2]=new Course("C++","1002",4);
        c[3]=new Course("C#","1003",2);
        c[4]=new Course("JAVA","1004",3);
        c[5]=new Course("HTML","1005",1);
        c[6]=new Course("LINUX","1006",2);
    }

    public void show_course(){
        for(int i=1;i<c.length;i++){
            System.out.println("课程名:"+c[i].name+" 课程id:"+c[i].id+" 学分:"+c[i].score);
        }
    }

}
