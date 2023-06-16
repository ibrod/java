package Practice5;

public class Test {
    public static void main(String[] args) {
        UserSystem userSystem = new UserSystem();
        User user = new User("张三", "123456");
        user.addCharacter(new Character("管理员", 1));
        user.addCharacter(new Character("用户", 2));
        userSystem.addUser(user);

        user = new User("李四", "111111");
        user.addCharacter(new Character("游客", 3));
        user.addCharacter(new Character("游客", 3));
        user.addCharacter(new Character("游客", 3));
        userSystem.addUser(user);

        user = new User("王五", "222222");
        user.addCharacter(new Character("管理员", 1));
        user.addCharacter(new Character("用户", 2));
        user.addCharacter(new Character("游客", 3));
        user.addCharacter(new Character("管理员", 1));
        user.addCharacter(new Character("用户", 2));
        user.addCharacter(new Character("游客", 3));
        userSystem.addUser(user);

        userSystem.showInfo();
    }
}
