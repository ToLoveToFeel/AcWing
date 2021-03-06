package _0002;

import java.util.Scanner;

/**
 * Date: 2020/12/23 9:59
 * Content:
 */
public class Main2 {

    public static void main(String[] args) throws Exception {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品数量
        int V = scan.nextInt();  // 背包容量
        int[] v = new int[N];  // 0~N-1 物品的体积
        int[] w = new int[N];  // 0~N-1 物品的价值
        for (int i = 0; i < N; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        scan.close();

        // 算法代码
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[V]);
    }
}
