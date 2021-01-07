package _0859;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/7 20:50
 * Content:
 */
public class Main {

    public static final int N = 200010;

    static int n, m;
    static int[] p = new int[N];  // 并查集

    static class Edge implements Comparable<Edge> {
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    private static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt(), w = scan.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        for (int i = 1; i <= n; i++) p[i] = i;

        // Kruskal算法
        Arrays.sort(edges);

        int res = 0, cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;

            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                res += w;
                cnt++;
            }
        }

        if (cnt < n - 1) System.out.println("impossible");
        else System.out.println(res);
    }
}
