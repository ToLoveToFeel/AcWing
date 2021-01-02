package _0848;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/2
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int n, m;  // 顶点数，边数
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;

    public static int[] d = new int[N];  // 入度
    public static int[] q = new int[N];  // 队列

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean topsort() {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++)
            if (d[i] == 0)
                q[++tt] = i;

        while (hh <= tt) {
            int t = q[hh++];

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) q[++tt] = j;
            }
        }

        return tt == n - 1;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
            d[b]++;
        }

        if (topsort()) {
            for (int i = 0; i < n; i++) System.out.print(q[i] + " ");
        } else {
            System.out.println(-1);
        }
    }
}
