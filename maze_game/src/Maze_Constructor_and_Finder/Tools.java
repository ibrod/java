package Maze_Constructor_and_Finder;

public class Tools {
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

    public static void pf_map(StringBuffer[] mp,int n,int m){
        for (int i = 0; i <= n + 1; i++) {
            System.out.println(mp[i]);
        }
    }

    public static void win(){
        System.out.println("��ϲ�㣬��ս�ɹ�!");
        System.out.println("�����������...");
        pfpasue();
    }

    public static void pfpasue() {
        try {
            new ProcessBuilder("cmd", "/c", "pause>nul").inheritIO().start().waitFor();
        } catch (Exception e) {}
    }
}
