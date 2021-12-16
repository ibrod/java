import Maze_Constructor_and_Finder.Generator;

public class Main {
    public static void main(String[] args) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int n = 40;
        int m = 150;
        char block = '┼';
        char road = ' ';
        StringBuffer[] mp = Generator.prim_create(n, m, block, road);
        for (int i = 0; i < n; i++) {
            System.out.println(mp[i]);
        }
        // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
