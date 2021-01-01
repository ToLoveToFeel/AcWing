package _0012;

import java.util.Scanner;

/**
 * Date: 2020/12/28 9:47
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int V = scan.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        // 算法代码
        int[][] dp = new int[N + 1][V + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i])
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - v[i]] + w[i]);
            }
        }

        int c = V;
        for (int i = 0; i < N; i++) {
            if (c >= v[i] && dp[i][c] == dp[i + 1][c - v[i]] + w[i]) {
                System.out.print(i + 1 + " ");
                c -= v[i];
            }
        }
    }
}
