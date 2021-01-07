package _0852;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Date: 2021/1/7 16:06
 * Content:
 */
public class Main {

    public static final int N = 10010;
    public static int n, m;  // 顶点数，边数
    // 稀疏图，使用邻接表存储
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] w = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;

    public static int[] dist = new int[N];    // 存储起始点(1号点)到其他点的最短距离
    public static int[] cnt = new int[N];    // cnt[x]存储1到x的最短路中经过的点数
    public static boolean[] st = new boolean[N];

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;  // 边(a, b) 的权重为c
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean spfa() {

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.push(i);
            st[i] = true;
        }

        while (!q.isEmpty()) {
            int t = q.peek();
            q.pop();
            st[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j]) {
                        q.push(j);
                        st[j] = true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // 读入点数，边数
        n = scan.nextInt();
        m = scan.nextInt();

        Arrays.fill(h, -1);
        // 读入所有的边
        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            add(a, b, c);  // 邻接表可以自动解决自环和重边的问题，不需要特殊处理
        }

        if (spfa()) System.out.println("Yes");
        else System.out.println("No");
    }
}