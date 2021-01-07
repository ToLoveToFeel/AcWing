package _0860;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/7 21:36
 * Content:
 */
public class Main {

    public static final int N = 100010, M = 200010;

    static int n, m;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int idx;
    static int[] color = new int[N];

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean dfs(int u, int c) {

        color[u] = c;

        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == -1) {
                if (!dfs(j, 1 - c)) return false;
            } else if (color[j] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
            add(b, a);
        }

        Arrays.fill(color, -1);
        boolean flag = true;
        for (int i = 1; i <= n; i++)
            if (color[i] == -1) {
                if (!dfs(i, 0)) {
                    flag = false;
                    break;
                }
            }

        if (flag) System.out.println("Yes");
        else System.out.println("No");
    }
}
