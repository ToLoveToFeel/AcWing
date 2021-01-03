package _0849;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/3 15:08
 * Content: 朴素Dijkstra算法          O(n^2)                适合于稠密图
 */
public class Main {

    public static final int N = 510;
    public static int n, m;  // 顶点数，边数
    public static int[][] g = new int[N][N];    // 稠密图，使用邻接矩阵存储
    public static int[] dist = new int[N];    // 存储起始点(1号点)到其他点的最短距离
    public static boolean[] st = new boolean[N];   // 标记当前点是否已经求出最短距离，默认都是false

    private static int dijkstra() {

        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;  // 起始点到起始点距离为0

        for (int i = 0; i < n; i++) {  // n次循环，每次得到一个解
            int t = -1;  // 记录不在s(已经求出最短距离的点的集合)距离最近的点
            for (int j = 1; j <= n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            st[t] = true;  // 得到一个解

            for (int j = 1; j <= n; j++)  // 用t更新其他点的距离
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
        }

        if (dist[n] == 0x3f3f3f3f) return -1;
        return dist[n];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // 读入点数，边数
        n = scan.nextInt();
        m = scan.nextInt();
        // 设置所有点之间距离都是无穷
        for (int i = 0; i < N; i++) Arrays.fill(g[i], 0x3f3f3f3f);
        // 读入所有的边
        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            g[a][b] = Math.min(g[a][b], c);  // 解决自环和重边的问题，只保留一条权值最小的
        }

        int t = dijkstra();

        System.out.println(t);
    }
}
