package _0843;

import java.util.Scanner;

/**
 * Date: 2020/12/30 19:54
 * Content: dfs 从左到右，从上到下一个格子一个格子的枚举
 */
public class Main2 {

    public static final int N = 20;

    public static int n;
    public static char[][] g;
    public static boolean[] row = new boolean[N];  // 某一行是否使用
    public static boolean[] col = new boolean[N];  // 某一列是否使用
    public static boolean[] dg = new boolean[N];  // 斜对角线是否被占用，右上到左下
    public static boolean[] udg = new boolean[N];  // 对角线是否被占用，左上到右下

    // (x, y)代表当前考虑的格子，s表示已经添加了几个皇后
    private static void dfs(int x, int y, int s) {

        if (y == n) {
            y = 0;
            x++;
        }

        if (x == n) {
            if (s == n) {
                for (int i = 0; i < n; i++) System.out.println(g[i]);
                System.out.println();
            }
            return;
        }

        // 不放皇后
        dfs(x, y + 1, s);

        // 放皇后
        if (!row[x] && !col[y] && !dg[x + y] && !udg[x - y + n]) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = true;
            dfs(x, y + 1, s + 1);
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = false;
            g[x][y] = '.';
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        g = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';

        dfs(0, 0, 0);
    }
}
