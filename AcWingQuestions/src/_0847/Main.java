package _0847;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/1
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int n, m;  // 顶点数，边数
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;

    public static int[] d = new int[N];  // 距离
    public static int[] q = new int[N];  // 队列

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int bfs() {
        int hh = 0, tt = -1;
        q[++tt] = 1;
        Arrays.fill(d, -1);

        d[1] = 0;
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t] + 1;
                    q[++tt] = j;
                }
            }
        }

        return d[n];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
        }

        System.out.println(bfs());
    }
}
