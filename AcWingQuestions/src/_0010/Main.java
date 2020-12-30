package _0010;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2020/12/30 9:42
 * Content:
 */
public class Main {

    public static final int N = 110;

    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx;

    private static int[][] dp;

    // 添加一条 a指向b的边
    private static void add(int a, int b) {

        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static void dfs(int u, int[] v, int[] w, int V) {

        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            dfs(son, v, w, V);

            for (int j = V - v[u]; j >= 0; j--)
                for (int k = 0; k <= j; k++)
                    dp[u][j] = Math.max(dp[u][j], dp[u][j - k] + dp[son][k]);
        }

        for (int i = V; i >= v[u]; i--) dp[u][i] =dp[u][i - v[u]] + w[u];
        for (int i = 0; i < v[u] && i <= V; i++) dp[u][i] = 0;
    }

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int V = scan.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            p[i] = scan.nextInt();
        }

        // 算法代码
        Arrays.fill(h, -1);
        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (p[i] == -1) root = i;
            else add(p[i], i);
        }

        dp = new int[N + 1][V + 1];
        dfs(root, v, w, V);
        System.out.println(dp[root][V]);
    }
}
