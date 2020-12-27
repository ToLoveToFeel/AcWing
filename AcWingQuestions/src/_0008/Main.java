package _0008;

import java.util.Scanner;

/**
 * Date: 2020/12/27 10:15
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品件数
        int V = scan.nextInt();  // 背包容积
        int M = scan.nextInt();  // 背包可承受的最大重量
        int[] v = new int[N];  // 体积
        int[] m = new int[N];  // 质量
        int[] w = new int[N];  // 价值
        for (int i = 0; i < N; i++) {
            v[i] = scan.nextInt();
            m[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        // 算法代码
        int[][] dp = new int[V + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--)
                for (int k = M; k >= m[i]; k--)
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
        }

        System.out.println(dp[V][M]);
    }
}
