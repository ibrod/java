public abstract class Drink {
    int id;
    String name;


    public Drink(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drink() {
    }


    public Drink(int id) {
        this.id = id;
    }

    public void drink() throws DrinkNotFoundException {
        Taste.taste(id);
    };
}
