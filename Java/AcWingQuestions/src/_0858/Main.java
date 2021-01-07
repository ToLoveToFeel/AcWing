package _0858;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/7 20:20
 * Content:
 */
public class Main {

    public static final int N = 510;
    public static final int INF = 0x3f3f3f3f;

    static int n, m;  // 点数，边数
    static int[][] g = new int[N][N];  // 邻接矩阵
    static int[] dist = new int[N];  // dist[j] 表示从已经求得mst的集合中到达j点的最短的一条
    static boolean[] st = new boolean[N];  // 已在mst集合中的点

    private static int prim() {
        Arrays.fill(dist, INF);

        int res = 0;  // 记录整个图的MST最小权值和
        for (int i = 0; i < n; i++) {
            // 寻找当前与mst集合连接的最小的边对应的顶点t
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            if (i != 0 && dist[t] == INF) return INF;  // 如果图不连通的话，不存在MST
            if (i != 0) res += dist[t];  // 这句话要放在更新的前面，否则，存在负权自环会更新dist[t]
            st[t] = true;

            for (int j = 1; j <= n; j++) dist[j] = Math.min(dist[j], g[t][j]);
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for (int i = 0; i < N; i++) Arrays.fill(g[i], INF);
        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }

        int t = prim();

        if (t == INF) System.out.println("impossible");
        else System.out.println(t);
    }
}
