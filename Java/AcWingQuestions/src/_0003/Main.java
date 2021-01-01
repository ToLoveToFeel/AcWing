package _0003;

import java.util.Scanner;

/**
 * Date: 2020/12/24 9:41
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品数量
        int V = scan.nextInt();  // 背包容积
        int[] v = new int[N];  // 物品体积
        int[] w = new int[N];  // 物品价值
        for (int i = 0; i < N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        scan.close();

        // 算法代码
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[V]);
    }
}
