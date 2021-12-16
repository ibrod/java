package Maze_Constructor_and_Finder;

import java.util.*;

public class Generator {
    public static int addx[] = { 1, 0, -1, 0 };
    public static int addy[] = { 0, 1, 0, -1 };
    public static char dr[] = { 'd', 'r', 'u', 'l' };

    public static StringBuffer[] blank_create(int n, int m, char block, char road) { // create blank map
        StringBuffer[] mp = new StringBuffer[n];
        for (int i = 0; i < n; i++) {
            mp[i] = new StringBuffer();
            for (int j = 0; j < m; j++) {
                mp[i].append(road);
            }
        }

        return mp;
    }

    public static StringBuffer[] prim_create(int n, int m, char block, char road) { // create blank map
        StringBuffer[] mp = new StringBuffer[n];
        for (int i = 0; i < n; i++) {
            mp[i] = new StringBuffer();
            for (int j = 0; j < m; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    mp[i].append(road);
                } else {
                    mp[i].append(block);
                }
            }
        } // 首先建出只含有block和road的地图

        Random edge = new Random();
        int rd = edge.nextInt(4) + 1;
        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        if (rd == 1) {
            sx = 1;
            sy = (edge.nextInt(m / 2) + 1) * 2 - 1;
        } else if (rd == 2) {
            sx = (edge.nextInt(n / 2) + 1) * 2 - 1;
            sy = 1;
        } else if (rd == 3) {
            sx = n / 2 * 2 - 1;
            sy = (edge.nextInt(m / 2) + 1) * 2 - 1;
        } else {
            sx = (edge.nextInt(n / 2) + 1) * 2 - 1;
            sy = m / 2 * 2 - 1;
        } // 随机在边缘选起点

        mp[sx].setCharAt(sy, '@');
        int maxdistance = 0;

        boolean vis[][] = new boolean[n][m];
        vis[sx][sy] = true;

        Pathinformation queue[] = new Pathinformation[n * m + 5];
        int head = 0, tail = 0;
        queue[tail] = new Pathinformation(sx, sy, 0);
        tail++;
        while (head < tail) {
            Pathinformation temp = queue[head];

            int rand = edge.nextInt(tail - head);
            temp = queue[head + rand];
            queue[head + rand] = queue[head];
            queue[head] = temp;
            // 随机交换队列中的元素，让地图更随机自然
            head++;
            if (temp.x == -1) {
                continue;
            }

            if (mp[temp.x].charAt(temp.y) == block) {
                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + addx[i];
                    int ny = temp.y + addy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        if (edge.nextInt(2) == 0) {
                            mp[temp.x].setCharAt(temp.y, road);
                        }
                        continue;
                    }
                    if (!vis[nx][ny] && mp[nx].charAt(ny) == road) {
                        mp[temp.x].setCharAt(temp.y, road);
                        vis[nx][ny] = true;
                        queue[tail] = new Pathinformation(nx, ny, temp.distance + 1);
                        tail++;
                    }
                }
            } else {

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + addx[i];
                    int ny = temp.y + addy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                        if (temp.distance > maxdistance) {
                            ex = temp.x;
                            ey = temp.y;
                            maxdistance = temp.distance;
                        } // 找出最长路径,即为终点
                        vis[nx][ny] = true;
                        queue[tail] = new Pathinformation(nx, ny, temp.distance + 1);
                        tail++;
                    }
                }

            }
        }

        mp[ex].setCharAt(ey, '$');
        return mp;
    }

}
