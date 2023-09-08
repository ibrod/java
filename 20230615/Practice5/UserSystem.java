package Practice5;

import java.util.Vector;

public class UserSystem {
    private Vector<User> users;
    public UserSystem() {
        this.users = new Vector<User>();
    }
    public boolean addUser(User user) {
        return this.users.add(user);
    }
    public boolean removeUser(User user) {
        return this.users.remove(user);
    }
    public boolean updateUser(User oldUser,User newUser) {
        return this.users.remove(oldUser) && this.users.add(newUser);
    }
    public void showInfo(){
        for(User user: this.users){
            user.showInfo();
            System.out.println();
        }
    }
    public User getUserByName(String username){
        for(User user: this.users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public User getUserByIndex(int index){
        return this.users.get(index);
    }

    public int getUserIndexByName(String username){
        for(int i = 0; i < this.users.size(); i++){
            if(this.users.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

    public int getUserIndexByUser(User user){
        return this.users.indexOf(user);
    }

    public int getUserCount(){
        return this.users.size();
    }

    public User backUser(){
        return this.users.lastElement();
    }

    public User frontUser(){
        return this.users.firstElement();
    }

}
