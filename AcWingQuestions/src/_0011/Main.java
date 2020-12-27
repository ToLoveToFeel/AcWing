package _0011;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2020/12/27 21:25
 * Content:
 */
public class Main {

    public static final int MOD = 1000000007;

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
        int[] dp = new int[V + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int[] g = new int[V + 1];  // 记录方案数
        g[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                int t = Math.max(dp[j], dp[j - v[i]] + w[i]);

                int s = 0;
                if (t == dp[j]) s += g[j];
                if (t == dp[j - v[i]] + w[i]) s += g[j - v[i]];
                if (s >= MOD) s -= MOD;

                dp[j] = t;
                g[j] = s;
            }
        }

        int max = 0;  // 最大价值
        for (int i = 0; i <= V; i++) max = Math.max(max, dp[i]);

        int res = 0;
        for (int i = 0; i <= V; i++) {
            if (max == dp[i]) {
                res += g[i];
                if (res >= MOD) res -= MOD;
            }
        }

        System.out.println(res);
    }
}
