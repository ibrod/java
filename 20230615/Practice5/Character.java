package Practice5;

import java.util.Objects;

public class Character {
    private String name;
    private int id;
    public Character(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Character){
            Character character = (Character)obj;
            return this.name.equals(character.name) && this.id == character.id;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name,id);
    }
    public Character() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
