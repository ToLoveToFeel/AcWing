package _0842;

import java.util.Scanner;

/**
 * Date: 2020/12/30 19:44
 * Content: dfs
 */
public class Main {

    public static final int N = 10;

    public static int n;
    public static int[] path = new int[N];
    public static boolean[] st = new boolean[N];

    private static void dfs(int u) {

        if (u == n) {
            for (int i = 0; i < n; i++) System.out.print(path[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        dfs(0);
    }
}
