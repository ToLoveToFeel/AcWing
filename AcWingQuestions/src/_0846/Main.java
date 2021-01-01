package _0846;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/1
 * Content:
 */
public class Main {

    public static final int N = 100010, M = N * 2;

    public static int n;
    public static int[] h = new int[N];
    public static int[] e = new int[M];
    public static int[] ne = new int[M];
    public static int idx = 0;
    public static boolean[] st = new boolean[N];

    public static int ans = N;

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    // 返回以u为根的子树中 点的数量
    private static int dfs(int u) {

        st[u] = true;

        int sum = 1;  // 记录当前子树的节点的个数
        int res = 0;  // 记录以删除u后的中心
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                int s = dfs(j);
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);

        ans = Math.min(ans, res);
        return sum;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
            add(b, a);
        }

        dfs(1);

        System.out.println(ans);
    }
}
