package Maze_Constructor_and_Finder;

import java.util.*;

public class Finder {
    public static int addx[] = { -1, 1, 0, 0 };
    public static int addy[] = { 0, 0, -1, 1 };
    // 上下左右
    public static char dr[] = { 'U', 'D', 'L', 'R' };

    public Pathinformation find(StringBuffer mp[], int n, int m) {
        int sx = 0, sy = 0, ex = 0, ey = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (mp[i].charAt(j) == '@') {
                    sx = i;
                    sy = j;
                } else if (mp[i].charAt(j) == '$') {
                    ex = i;
                    ey = j;
                }
            }
        }

        boolean visited[][] = new boolean[n + 2][m + 2];
        Queue<Pathinformation> q = new LinkedList<Pathinformation>();
        q.add(new Pathinformation(sx, sy, 0,new StringBuffer()));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Pathinformation temp = q.poll();
            if (temp.x == ex && temp.y == ey) {
                return temp;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + addx[i];
                int ny = temp.y + addy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny]
                        && (mp[nx].charAt(ny) == ' ' || mp[nx].charAt(ny) == '@' || mp[nx].charAt(ny) == '$')) {
                    visited[nx][ny] = true;
                    StringBuffer sb = new StringBuffer(temp.path);
                    sb.append(dr[i]);
                    Pathinformation newtemp = new Pathinformation(nx, ny, temp.distance + 1,sb);
                    q.add(newtemp);
                }
            }
        }
        return null;// not found
    }

    private int convert(char ch){
        if(ch=='U') return 0;
        if(ch=='D') return 1;
        if(ch=='L') return 2;
        return 3;
    }

    public void instruct(StringBuffer mp[], int n, int m) throws Exception {
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (mp[i].charAt(j) == '@') {
                    sx = i;
                    sy = j;
                } else if (mp[i].charAt(j) == '$') {
                    ex = i;
                    ey = j;
                }
            }
        }
        Pathinformation p=find(mp,n,m);
        Tools.clear_screen();
        int x=sx,y=sy;
        int ax,ay;
        for(int k=0;k<p.path.length()-1;k++){
            ax=x+addx[convert(p.path.charAt(k))];
            ay=y+addy[convert(p.path.charAt(k))];
            char ch=mp[x].charAt(y);
            mp[x].setCharAt(y, mp[ax].charAt(ay));
            mp[ax].setCharAt(ay, ch);
            x=ax;
            y=ay;
            Tools.clear_screen();
            System.out.println("按任意键进行下一步演示...");
            Tools.pf_map(mp, n, m);
            Tools.pfpasue();
        }
        instruct_end();
    }
    public void instruct_end(){
        Tools.clear_screen();
        System.out.println("演示结束，学会了吗？");
        System.out.println("按任意键继续...");
        Tools.pfpasue();
    }
}
