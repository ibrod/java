package Maze_Constructor_and_Finder;
import java.util.*;

public class Generator {
    public static int addx[] = { -1, 1, 0, 0 };
    public static int addy[] = { 0, 0, -1, 1 };
    // ��������
    public static char dr[] = { 'U', 'D', 'L', 'R' };
    public static char blocktype[] = { '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��' };

    // �ö����Ʊ�ʾ����ʾ�ϰ���֮������ӹ�ϵ����λ����0��ʾ�����ӣ�1��ʾ�����ӣ���λ������������Ϊ�������ҵ��������

    public boolean[][] build_init_map(int n, int m) {
        boolean blockmap[][] = new boolean[n + 2][m + 2];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= m + 1; j++) {
                if (i == 0 || i == n + 1 || j == 0 || j == m + 1) {
                    blockmap[i][j] = true;
                    continue;
                } // �߿���Ҫ�����ϰ���

                if (i % 2 == 0 && j % 2 == 0) {
                    blockmap[i][j] = false;
                } else {
                    blockmap[i][j] = true;
                } // ż����ż���в���Ҫ�����ϰ���
            }
        } // ���Ƚ���ֻ����block��road�ĵ�ͼ
        return blockmap;
    }

    public StringBuffer[] prim_create(int n, int m) { // create blank map
        // StringBuffer[] mp = new StringBuffer[n+2];
        Random random = new Random();
        int rd = random.nextInt(4) + 1;
        int sx = 0, sy = 0;// ��ʼ��
        int ex = 0, ey = 0;// �յ�
        if (rd == 1) {// �ڱ�Ե�����ѡ���
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
        } // ����ڱ�Եѡ���

        boolean blockmap[][] = build_init_map(n, m);
        int maxdistance = 0;

        boolean vis[][] = new boolean[n + 2][m + 2];// ��¼���ʹ��ĵ�
        vis[sx][sy] = true;// �������Ϊ�ѷ���

        Pathinformation queue[] = new Pathinformation[(n + 2) * (m + 2) + 5];
        int head = 0, tail = 0;
        queue[tail] = new Pathinformation(sx, sy, 0);
        tail++;
        while (head < tail) {
            int rand = random.nextInt(tail - head);
            Pathinformation temp = queue[head + rand];
            queue[head + rand] = queue[head];
            queue[head] = temp;
            // �������������е�Ԫ�ؽ�����Ȼ��ȡ����ͷ���õ�ͼ�������Ȼ
            head++;

            if (blockmap[temp.x][temp.y] == true) {// ��������ϰ���
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

            } else {// �����ϰ���

                if (temp.distance > maxdistance) {
                    ex = temp.x;
                    ey = temp.y;
                    maxdistance = temp.distance;
                } // �ҳ��·��,��Ϊ�յ�

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
        boolean vis[][] = new boolean[n + 2][m + 2];// ��¼���ʹ��ĵ�
        boolean blockmap[][] = build_init_map(n, m);
        Random random = new Random();
        int sx = (random.nextInt(n / 2) + 1) * 2, sy = (random.nextInt(m / 2) + 1) * 2;// ���ѡ��һ���������
        vis[sx][sy] = true;// �������Ϊ�ѷ���
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
        if (blockmap[x][y] == true) {// �ϰ���
            for (int j = 0; j < 4; j++) {
                int temp = random.nextInt(4 - j);
                int i = order[temp + j];
                order[temp + j] = order[j];
                order[j] = i;
                // �������dfs
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
        } else {// �����ϰ���
            for (int j = 0; j < 4; j++) {
                int temp = random.nextInt(4 - j);
                int i = order[temp + j];
                order[temp + j] = order[j];
                order[j] = i;
                // �������dfs
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
                System.out.print(blockmap[i][j] ? "��" : " ");
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
