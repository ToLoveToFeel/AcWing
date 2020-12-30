package _0844;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2020/12/30 21:49
 * Content:
 */
public class Main {

    public static class MyPair {
        int first;
        int second;

        public MyPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static final int N = 110;

    public static int n, m;
    public static int[][] g = new int[N][N];  // 迷宫
    public static int[][] d = new int[N][N];  // 存储到达该点的最短距离
    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 上右下左
    public static MyPair[] q = new MyPair[N * N];

    private static int bfs() {

        int hh = 0, tt = -1;
        q[++tt] = new MyPair(0, 0);

        for (int i = 0; i < N; i++) Arrays.fill(d[i], -1);
        d[0][0] = 0;

        while (hh <= tt) {

            MyPair t = q[hh++];
            for (int i = 0; i < 4; i++) {
                int x = t.first + dir[i][0], y = t.second + dir[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {
                    d[x][y] = d[t.first][t.second] + 1;
                    q[++tt] = new MyPair(x, y);
                }
            }
        }

        return d[n - 1][m - 1];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = scan.nextInt();

        System.out.println(bfs());
    }
}
