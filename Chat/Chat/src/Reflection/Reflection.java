package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        // 利用person类，派生一个student类和teacher类，通过Class.forName(args[0]).newInstance()，动态创建实例;
        try {
            // 利用反射机制编写一个程序，这个程序能完成类中所有的成员变量赋值，并把操作信息输出到控制台。

            // 1.获取Class对象
            Class<?> c0 = Class.forName("Reflection.Person");

            // 2.获取构造方法
            Constructor<?> con0 = c0.getConstructor(String.class, int.class);

            // 3.创建对象
            Object obj0 = con0.newInstance("Alice", 18);
            System.out.println(obj0);

            //4.获取类名
            String className = c0.getName();
            System.out.println(className);


            System.out.println("=========================================");
            // 1.获取Class对象
            Class<?> c = Class.forName("Reflection.Student");

            // 2.获取构造方法
            Constructor<?> con = c.getConstructor(String.class, int.class);

            // 3.创建对象
            Object obj2 = con.newInstance("张三", 23);

            // 4.获取成员变量

            // 4.1获取所有的成员变量
            // Field[] fields = c.getFields();

            // 4.2获取指定的成员变量
            Field field = c.getField("name");
            System.out.println("使用Field获取'name'成员变量测试:" + field.get(obj2).toString());

            // 4.3给成员变量赋值
            // field.set(obj2, "李四");

            System.out.println(obj2);

            // 5.获取成员方法

            // 5.1获取所有的成员方法
            // Method[] methods = c.getMethods();

            // 5.2获取指定的成员方法

            // 对姓名进行操作
            Method gn = c.getMethod("getName");
            System.out.println("反射调用setName前查询的姓名为:" + gn.invoke(obj2).toString());
            Method method = c.getMethod("setName", String.class);
            method.invoke(obj2, "王五");
            System.out.println("反射调用setName后查询的姓名为:" + gn.invoke(obj2).toString());

            // 对年龄进行操作
            Method ga = c.getMethod("getAge");
            System.out.println("反射调用setAge前查询的年龄为:" + ga.invoke(obj2).toString());
            Method method1 = c.getMethod("setAge", int.class);
            method1.invoke(obj2, 24);
            System.out.println("反射调用setAge后查询的年龄为:" + ga.invoke(obj2).toString());

            // 6.获取类名
            System.out.println("类名:" + c.getName());

            // 7.获取父类
            System.out.println("父类:" + c.getSuperclass().getName());


            System.out.println("=========================================");
            // 1.获取Class对象
            Class<?> c3 = Class.forName("Reflection.Teacher");

            // 2.获取构造方法
            Constructor<?> con3 = c3.getConstructor(String.class, int.class);

            // 3.创建对象
            Object obj3 = con3.newInstance("Bob", 36);

            gn=c3.getMethod("getName");
            System.out.println(gn.invoke(obj3).toString());

            ga=c3.getMethod("getAge");
            System.out.println(ga.invoke(obj3).toString());

            //4.获取类名
            System.out.println("类名:" + c3.getName());

            //5.获取父类
            System.out.println("父类:" + c3.getSuperclass().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
