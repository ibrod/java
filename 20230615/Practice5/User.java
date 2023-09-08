package Practice5;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private String password;
    private Set<Character> characters;
    /*
     * 1.增加用户功能(1个用户可以添加多个角色信息)
     * 2.修改用户功能(根据用户名修改密码，以及根据用户名修改用户的角色信息)
     * 3.删除用户信息（根据用户名删除）
     * 4.查询用户信息（显示用户名、密码和该用户的所有角色信息）
     * 5.退出
     */

    public boolean addCharacter(Character character) {
        return this.characters.add(character);
    }

    public boolean removeCharacter(Character character) {
        return this.characters.remove(character);
    }

    public boolean updatePassword(String password) {
        this.password = password;
        return true;
    }

    public boolean updateCharacter(Character oldCharacter,Character newCharacter) {
        return this.characters.remove(oldCharacter) && this.characters.add(newCharacter);
    }

    public void showInfo(){
        System.out.println("用户名：" + this.username);
        System.out.println("密码：" + this.password);
        System.out.println("角色信息：");
        for(Character character: this.characters){
            System.out.println("角色名：" + character.getName() + "，角色ID：" + character.getId());
        }
    }

    public User(String username, String password, Set<Character> characters) {
        this.username = username;
        this.password = password;
        this.characters = characters;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.characters = new HashSet<>();
    }


    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

}
