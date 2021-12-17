package Maze_Constructor_and_Finder;

public class Pathinformation {
    
    public Pathinformation(int x, int y, int distance, StringBuffer path) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.path = path;
    }
    
    public Pathinformation(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public Pathinformation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x;
    public int y;
    public int distance;
    public StringBuffer path;
}
