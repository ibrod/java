package Practice5;

import java.util.Scanner;

public class Ui {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        UserSystem userSystem = new UserSystem();
        System.out.println("欢迎使用用户管理系统");
        int choice = 0;
        while (choice != 7) {
            System.out.println();
            System.out.println("--------------------");
            System.out.println("当前用户数：" + userSystem.getUserCount());
            System.out.println("请选择功能");
            System.out.println("1.增加用户功能 2.修改用户功能 3.删除用户功能  4.查询用户功能 5.列举所有用户和信息 6.用户角色管理 7.退出系统");
            System.out.print(">>>");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入用户名和密码");
                    System.out.print(">>>");
                    String username = scanner.next();
                    String password = scanner.next();
                    if(userSystem.getUserByName(username) != null){
                        System.out.println("该用户已存在");
                        break;
                    }
                    User user = new User(username, password);
                    userSystem.addUser(user);
                    break;
                case 2:
                    System.out.println("请输入要修改的用户名");
                    System.out.print(">>>");
                    username = scanner.next();
                    user = userSystem.getUserByName(username);
                    if (user == null) {
                        System.out.println("该用户不存在");
                        break;
                    }
                    System.out.println("请输入新的用户名和密码");
                    System.out.print(">>>");
                    username = scanner.next();
                    password = scanner.next();
                    User newUser = new User(username, password);
                    // System.out.println("请输入用户角色信息");
                    // System.out.print(">>>");
                    // characterName = scanner.next();
                    // characterId = scanner.nextInt();
                    // user.addCharacter(new Character(characterName, characterId));
                    userSystem.updateUser(user, newUser);
                    System.out.println("修改成功");
                    break;
                case 3:
                    System.out.println("请输入要删除的用户名");
                    System.out.print(">>>");
                    username = scanner.next();
                    user = userSystem.getUserByName(username);
                    if (user == null) {
                        System.out.println("该用户不存在");
                        break;
                    }
                    userSystem.removeUser(user);
                    System.out.println("删除成功");
                    break;
                case 4:
                    System.out.println("请输入要查询的用户名");
                    System.out.print(">>>");
                    username = scanner.next();
                    user = userSystem.getUserByName(username);
                    if (user == null) {
                        System.out.println("该用户不存在");
                        break;
                    }
                    user.showInfo();
                    break;
                case 5:
                    userSystem.showInfo();
                    break;
                case 6:
                    System.out.println("请输入要管理的用户名");
                    System.out.print(">>>");
                    username = scanner.next();
                    user = userSystem.getUserByName(username);
                    if (user == null) {
                        System.out.println("该用户不存在");
                        break;
                    }
                    characterManage(user);
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
        scanner.close();
    }
    public void characterManage(User user){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String characterName;
        int characterId;
        while (choice != 3) {
            System.out.println("当前用户角色信息：");
            for(Character character: user.getCharacters()){
                System.out.println("角色名：" + character.getName() + "，角色ID：" + character.getId());
            }
            System.out.println();
            System.out.println("请选择功能");
            System.out.println("1.增加用户角色 2.删除用户角色 3.退出用户角色管理");
            System.out.print(">>>");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入用户角色信息(格式:角色名 角色ID)");
                    System.out.print(">>>");
                    characterName = scanner.next();
                    characterId = scanner.nextInt();
                    user.addCharacter(new Character(characterName, characterId));
                    break;
                case 2:
                    System.out.println("请输入要删除的用户角色信息(格式:角色名 角色ID)");
                    System.out.print(">>>");
                    characterName = scanner.next();
                    characterId = scanner.nextInt();
                    user.removeCharacter(new Character(characterName, characterId));
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }

}
