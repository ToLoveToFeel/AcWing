package _0004;

import java.util.Scanner;

/**
 * Date: 2020/12/24 10:05
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品数量
        int V = scan.nextInt();  // 背包容量
        int[] v = new int[N];  // 物品的体积
        int[] w = new int[N];  // 物品的价值
        int[] s = new int[N];  // 物品的数量
        for (int i = 0; i < N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }
        scan.close();

        // 算法代码
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {  // 1.先遍历物品
            for (int j = V; j >= v[i]; j--) {  // 2.再遍历体积
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {  // 3.最后遍历决策
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }

        System.out.println(dp[V]);
    }
}
