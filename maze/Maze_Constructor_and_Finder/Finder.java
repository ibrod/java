package Maze_Constructor_and_Finder;

import java.util.*;

public class Finder {
    public static int addx[] = { 1, 0, -1, 0 };
    public static int addy[] = { 0, 1, 0, -1 };
    public static char dr[] = { 'd', 'r', 'u', 'l' };

    public static Pathinformation find(StringBuffer mp[], int sx, int sy, int ex, int ey, char block, char road) {

        int n = mp.length;
        boolean[][] visited = new boolean[n][n];

        Queue<Pathinformation> q = new LinkedList<Pathinformation>();
        q.add(new Pathinformation(sx, sy, 0, new StringBuffer()));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Pathinformation temp = q.poll();
            if (temp.x == ex && temp.y == ey)
                return temp;

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + addx[i];
                int ny = temp.y + addy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && mp[nx].charAt(ny) == road) {
                    visited[nx][ny] = true;
                    temp.dir.append(dr[i]);
                    q.add(new Pathinformation(nx, ny, temp.distance + 1, temp.dir));
                    temp.dir.deleteCharAt(temp.dir.length() - 1);
                }
            }

        }
        return null;// not found

    }
}
