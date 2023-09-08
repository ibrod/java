package Practice3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new Student("Tom", 18, 100, "class05"));
        list.add(new Student("Jerry", 22, 70, "class04"));
        list.add(new Student("Owen", 25, 90, "class05"));
        list.add(new Student("Jim", 30, 80, "class05"));
        list.add(new Student("Steve", 28, 66, "class06"));
        list.add(new Student("Kevin", 24, 100, "class04"));

        System.out.println("所有学生的平均分: " + averageScore());
        System.out.println("各个班级的平均分: " + averageScoreByClass());
    }

    public static int averageScore() {
        int sum = 0;
        for (Student student : list) {
            sum += student.getScore();
        }
        return sum / list.size();
    }

    public static Map<String, Integer> averageScoreByClass() {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (Student student : list) {
            if (map.containsKey(student.getClassNum())) {
                map.put(student.getClassNum(), map.get(student.getClassNum()) + student.getScore());
                count.put(student.getClassNum(), count.get(student.getClassNum()) + 1);
            } else {
                map.put(student.getClassNum(), student.getScore());
                count.put(student.getClassNum(), 1);
            }
        }
        for (String key : map.keySet()) {
            map.put(key, map.get(key) / count.get(key));
        }
        return map;
    }

    public static int averageScoreByClassNum(String classNum) {
        int sum = 0;
        int count = 0;
        for (Student student : list) {
            if (student.getClassNum().equals(classNum)) {
                sum += student.getScore();
                count++;
            }
        }
        return sum / count;
    }

    public static void printStudent() {
        System.out.println("name\tage\tscore\tclassNum");
        for (Student student : list) {
            System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getScore() + "\t"
                    + student.getClassNum());
        }
    }

    public static void printStudentByClassNum(String classNum) {
        System.out.println("name\tage\tscore\tclassNum");
        for (Student student : list) {
            if (student.getClassNum().equals(classNum)) {
                System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getScore() + "\t"
                        + student.getClassNum());
            }
        }
    }

}
