package Maze_Constructor_and_Finder;


public class Pathinformation {
    
    public Pathinformation(int x, int y, int distance, StringBuffer dir) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.dir = dir;
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

    int x;
    int y;
    int distance;
    StringBuffer dir;
}
