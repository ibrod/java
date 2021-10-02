package temp;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("请输入金币数量:");
        Scanner sc = new Scanner(System.in);
        int gold = sc.nextInt();
        sc.close();
        Main m = new Main();

        m.greedy(gold);//贪心法求解(时间复杂度 O(1))
        m.DP(gold);//动态规划(完全背包)法求解(时间复杂度 O(n))
        m.brute_Force(gold);//暴力枚举法(纯暴力)求解，这也是题目所给的做法(时间复杂度 O(n*n))
        m.brute_Force_Improved(gold);//暴力枚举法(优化版)(此处也用到了一定的贪心思想)(时间复杂度 O(n))
    }

    void brute_Force(int gold) {
        System.out.println("暴力枚举法(纯暴力):(时间复杂度 O(n*n))");
        int a=gold/16;
        int b=gold/20;
        int itm1=0,itm2=0;
        int sum=0,temp=0;
        for(int i=0;i<=a;i++){
            for(int j=0;j<=b;j++){
                if(i*16+j*20<=gold){
                    temp=i*20+j*30;
                    if(temp>sum){
                        itm1=j;
                        itm2=i;
                        sum=temp;
                    }
                }
            }
        }
        System.out.println("最大生命力为:" + sum);
        System.out.println("仙女草数量:" + itm1);
        System.out.println("银河梭数量:" + itm2);
    }

    void brute_Force_Improved(int gold) {
        System.out.println("暴力枚举法(优化版):(时间复杂度 O(n))");
        int a=gold/16;
        int itm1=0,itm2=0;
        int sum=0,temp=0;
        for(int i=0;i<=a;i++){
            temp=i*20+(gold-i*16)/20*30;
            if(temp>sum){
                itm2=i;
                itm1=(gold-i*16)/20;
                sum=temp;
            }
        }
        System.out.println("最大生命力为:" + sum);
        System.out.println("仙女草数量:" + itm1);
        System.out.println("银河梭数量:" + itm2);
    }

    void greedy(int gold) {
        System.out.println("贪心法:(时间复杂度 O(1))");
        if(gold<16){
            System.out.println("最大生命力为:0" );
            System.out.println("仙女草数量:0");
            System.out.println("银河梭数量:0");
            return;
        }
        int a = (gold % 20 / 16) * 20 + (gold / 20) * 30;
        int b = ((gold - 16) % 20 / 16 + 1) * 20 + ((gold - 16) / 20) * 30;
        if (a > b) {
            System.out.println("最大生命力为:" + a);
            System.out.println("仙女草数量:" + (gold / 20));
            System.out.println("银河梭数量:" + (gold % 20 / 16));
        } else {
            System.out.println("最大生命力为:" + b);
            System.out.println("仙女草数量:" + ((gold - 16) / 20));
            System.out.println("银河梭数量:" + ((gold - 16) % 20 / 16 + 1));
        }

    }

    void DP(int gold) {
        System.out.println("动态规划(完全背包)法:(时间复杂度 O(n))");
        int dp[][] = new int[gold + 1][2];
        int v[] = { 0, 20, 16 };
        int w[] = { 0, 30, 20 };
        for (int i = 1; i <= 2; i++) {//此处只有两次执行，为常数，故不计入时间复杂度计算
            for (int j = v[i]; j <= gold; j++) {
                if (dp[j][0] < dp[j - v[i]][0] + w[i]) {
                    dp[j][0] = dp[j - v[i]][0] + w[i];
                    dp[j][1] = i;
                }
            }
        }
        System.out.println("最大生命力为:" + dp[gold][0]);

        int arr[] = { 0, 0, 0 };
        int lst = gold;
        while (true) {
            if (dp[lst][1] == 0) {
                break;
            } else {
                arr[dp[lst][1]]++;
                lst -= v[dp[lst][1]];
            }
        }

        System.out.println("仙女草数量:" + arr[1]);
        System.out.println("银河梭数量:" + arr[2]);
    }

}
