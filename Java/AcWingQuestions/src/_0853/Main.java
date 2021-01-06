package _0853;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/6 22:16
 * Content:
 */
public class Main {

    public static final int N = 510, M = 10010;

    public static int n, m, k;
    public static int[] dist = new int[N];  // 存储最短距离
    public static int[] backup = new int[N];  // 存储上次dist结果，防止发生串联

    public static int[][] edges = new int[M][3];  // 第二维分别指：(a, b, w)

    private static int bellman_ford() {

        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;

        for (int i = 0; i < k; i++) {
            System.arraycopy(dist, 0, backup, 0, N);
            for (int j = 0; j < m; j++) {
                int a = edges[j][0], b = edges[j][1], w = edges[j][2];
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }

        if (dist[n] > 0x3f3f3f3f / 2) return -1;
        return dist[n];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt(), w = scan.nextInt();
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = w;
        }

        int t = bellman_ford();

        if (t == -1) System.out.println("impossible");
        else System.out.println(t);
    }
}
