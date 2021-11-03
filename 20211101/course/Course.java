package course;

public class Course {
    public String name;
    public String id;
    public int score;//学分
    public int grades;//成绩
    public Course(String name, String id, int score) {
        grades=0;
        this.name = name;
        this.id = id;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public static void pfc(Course c){
        System.out.println("课程名:"+c.name+",课程id:"+c.id+"成绩:"+c.score);
    }
}
