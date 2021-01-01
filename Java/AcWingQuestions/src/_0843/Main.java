package _0843;

import java.util.Scanner;

/**
 * Date: 2020/12/30 19:54
 * Content: dfs 一行一行的处理
 */
public class Main {

    public static final int N = 20;

    public static int n;
    public static char[][] g;
    public static boolean[] col = new boolean[N];  // 某一列是否使用
    public static boolean[] dg = new boolean[N];  // 斜对角线是否被占用，右上到左下
    public static boolean[] udg = new boolean[N];  // 对角线是否被占用，左上到右下

    private static void dfs(int u) {

        if (u == n) {
            for (int i = 0; i < n; i++) System.out.println(g[i]);
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[u - i + n]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[u - i + n] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[u - i + n] = false;
                g[u][i] = '.';
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        g = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';

        dfs(0);
    }
}
