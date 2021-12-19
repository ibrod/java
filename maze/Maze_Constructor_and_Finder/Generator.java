package Maze_Constructor_and_Finder;
import java.util.*;

public class Generator {
    public static int addx[] = { -1, 1, 0, 0 };
    public static int addy[] = { 0, 0, -1, 1 };
    // 上下左右
    public static char dr[] = { 'U', 'D', 'L', 'R' };
    public static char blocktype[] = { '┼', '─', '─', '─', '│', '┌', '┐', '┬', '│', '└', '┘', '┴', '│', '├', '┤', '┼' };

    // 用二进制表示法表示障碍物之间的连接关系，四位数，0表示无连接，1表示有连接，四位数从左到右依次为上下左右的连接情况
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

    public boolean[][] build_init_map(int n, int m) {
        boolean blockmap[][] = new boolean[n + 2][m + 2];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= m + 1; j++) {
                if (i == 0 || i == n + 1 || j == 0 || j == m + 1) {
                    blockmap[i][j] = true;
                    continue;
                } // 边框需要设置障碍物

                if (i % 2 == 0 && j % 2 == 0) {
                    blockmap[i][j] = false;
                } else {
                    blockmap[i][j] = true;
                } // 偶数行偶数列不需要设置障碍物
            }
        } // 首先建出只含有block和road的地图
        return blockmap;
    }

    public StringBuffer[] prim_create(int n, int m) { // create blank map
        // StringBuffer[] mp = new StringBuffer[n+2];
        Random random = new Random();
        int rd = random.nextInt(4) + 1;
        int sx = 0, sy = 0;// 初始点
        int ex = 0, ey = 0;// 终点
        if (rd == 1) {// 在边缘随机挑选起点
            sx = 1;
            sy = (random.nextInt(m / 2) + 1) * 2;
        } else if (rd == 2) {
            sx = (random.nextInt(n / 2) + 1) * 2;
            sy = 1;
        } else if (rd == 3) {
            sx = n / 2 * 2;
            sy = (random.nextInt(m / 2) + 1) * 2;
        } else {
            sx = (random.nextInt(n / 2) + 1) * 2;
            sy = m / 2 * 2;
        } // 随机在边缘选起点

        boolean blockmap[][] = build_init_map(n, m);
        int maxdistance = 0;

        boolean vis[][] = new boolean[n + 2][m + 2];// 记录访问过的点
        vis[sx][sy] = true;// 起点设置为已访问

        Pathinformation queue[] = new Pathinformation[(n + 2) * (m + 2) + 5];
        int head = 0, tail = 0;
        queue[tail] = new Pathinformation(sx, sy, 0);
        tail++;
        while (head < tail) {
            int rand = random.nextInt(tail - head);
            Pathinformation temp = queue[head + rand];
            queue[head + rand] = queue[head];
            queue[head] = temp;
            // 队首随机与队列中的元素交换，然后取出队头，让地图更随机自然
            head++;

            if (blockmap[temp.x][temp.y] == true) {// 这个点是障碍块
                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + addx[i];
                    int ny = temp.y + addy[i];
                    if (nx > 0 && nx <= n && ny > 0 && ny <= m && !vis[nx][ny] && blockmap[nx][ny] == false) {
                        blockmap[temp.x][temp.y] = false;
                        vis[nx][ny] = true;
                        queue[tail] = new Pathinformation(nx, ny, temp.distance + 1);
                        tail++;
                    }
                }

                if (blockmap[temp.x][temp.y] == true && temp.x == 1 || temp.y == 1 || temp.x == n || temp.y == m) {
                    if (random.nextInt(10) > 0) {
                        blockmap[temp.x][temp.y] = false;
                    }
                }

            } else {// 不是障碍块

                if (temp.distance > maxdistance) {
                    ex = temp.x;
                    ey = temp.y;
                    maxdistance = temp.distance;
                } // 找出最长路径,即为终点

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + addx[i];
                    int ny = temp.y + addy[i];
                    if (nx > 0 && nx <= n && ny > 0 && ny <= m && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue[tail] = new Pathinformation(nx, ny, temp.distance + 1);
                        tail++;
                    }
                }
            }
        }
        
        return build_map(blockmap, n, m, sx, sy, ex, ey);
    }

    public StringBuffer[] dfs_create(int n, int m) {
        boolean vis[][] = new boolean[n + 2][m + 2];// 记录访问过的点
        boolean blockmap[][] = build_init_map(n, m);
        Random random = new Random();
        int sx = (random.nextInt(n / 2) + 1) * 2, sy = (random.nextInt(m / 2) + 1) * 2;// 随机选择一个可用起点
        vis[sx][sy] = true;// 起点设置为已访问
        dfs(blockmap, vis, n, m, sx, sy);

        boolean visited[][] = new boolean[n + 2][m + 2];
        Queue<Pathinformation> q = new LinkedList<Pathinformation>();
        q.add(new Pathinformation(sx, sy, 0));
        visited[sx][sy] = true;
        int maxdistance = 0;
        int ex=0,ey=0;
        while (!q.isEmpty()) {
            Pathinformation temp = q.poll();
            if(temp.distance>maxdistance){
                ex = temp.x;
                ey = temp.y;
                maxdistance = temp.distance;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + addx[i];
                int ny = temp.y + addy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny] && blockmap[nx][ny] == false) {
                    visited[nx][ny] = true;
                    q.add(new Pathinformation(nx, ny, temp.distance + 1));
                }
            }
        }
        return build_map(blockmap, n, m, sx, sy, ex, ey);
    }

    private void dfs(boolean blockmap[][], boolean vis[][], int n, int m, int x, int y) {
        int order[] = { 0, 1, 2, 3 };
        Random random = new Random();
        if (blockmap[x][y] == true) {// 障碍块
            for (int j = 0; j < 4; j++) {
                int temp = random.nextInt(4 - j);
                int i = order[temp + j];
                order[temp + j] = order[j];
                order[j] = i;
                // 随机方向dfs
                int nx = x + addx[i];
                int ny = y + addy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !vis[nx][ny] && blockmap[nx][ny] == false) {
                    vis[nx][ny] = true;
                    blockmap[x][y] = false;
                    dfs(blockmap, vis, n, m, nx, ny);
                }
            }
            if (blockmap[x][y] == true && x == 1 || y == 1 || x == n || y == m) {
                if (random.nextInt(10) > 0) {
                    blockmap[x][y] = false;
                }
            }
        } else {// 不是障碍块
            for (int j = 0; j < 4; j++) {
                int temp = random.nextInt(4 - j);
                int i = order[temp + j];
                order[temp + j] = order[j];
                order[j] = i;
                // 随机方向dfs
                int nx = x + addx[i];
                int ny = y + addy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    dfs(blockmap, vis, n, m, nx, ny);

                }
            }
        }
    }

    public void print_blockmap(boolean blockmap[][], int n, int m) {
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                System.out.print(blockmap[i][j] ? "┼" : " ");
            }
            System.out.println();
        }
    }

    public StringBuffer[] build_map(boolean[][] blockmap, int n, int m, int sx, int sy, int ex, int ey) {
        StringBuffer mp[] = new StringBuffer[n + 2];
        for (int i = 0; i <= n + 1; i++) {
            mp[i] = new StringBuffer();
            for (int j = 0; j <= m + 1; j++) {
                if (blockmap[i][j]) {
                    int num = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + addx[k];
                        int ny = j + addy[k];
                        if (nx >= 0 && nx <= n + 1 && ny >= 0 && ny <= m + 1 && blockmap[nx][ny] == true) {
                            num += (1 << (3 - k));
                        }
                    }
                    mp[i].append(blocktype[num]);
                } else {
                    mp[i].append(' ');
                }
            }
        }
        mp[sx].setCharAt(sy, '@');
        mp[ex].setCharAt(ey, '$');
        return mp;
    }

}
