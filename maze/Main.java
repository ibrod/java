import Maze_Constructor_and_Finder.Finder;
import Maze_Constructor_and_Finder.Generator;
import Maze_Constructor_and_Finder.Pathinformation;
import Maze_Constructor_and_Finder.Tools;

public class Main {
    public static void main(String[] args) throws Exception {
        Tools.clear_screen();
        int n = 30;
        int m = 170;
        Generator g = new Generator();
        StringBuffer[] mp = g.dfs_create(n, m);
        // for (int i = 0; i <= n + 1; i++) {
        //     System.out.println(mp[i]);
        // }

         Finder fd = new Finder();
         fd.instruct(mp, n, m);
        // System.out.println("Shortest path: " + p.distance);
        // System.out.println("Path: " + p.path);
    }



}
