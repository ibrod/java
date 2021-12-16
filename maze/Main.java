import Maze_Constructor_and_Finder.Finder;
import Maze_Constructor_and_Finder.Generator;
import Maze_Constructor_and_Finder.Pathinformation;

public class Main {
    public static void main(String[] args) throws Exception {
        clear_screen();
        int n = 5;
        int m = 20;
        Generator g = new Generator();
        StringBuffer[] mp = g.prim_create(n, m);
        for (int i = 0; i <= n + 1; i++) {
            System.out.println(mp[i]);
        }

        Finder fd = new Finder();
        Pathinformation p = fd.find(mp, n, m);
        System.out.println("Shortest path: " + p.distance);
        System.out.println("Path: " + p.path);
    }

    public static void clear_screen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }

    }

}
