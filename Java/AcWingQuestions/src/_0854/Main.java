package _0854;

import java.util.Scanner;

/**
 * Date: 2021/1/7 16:41
 * Content:
 */
public class Main {

    public static final int N = 210;
    public static final int INF = 0x3f3f3f3f;

    static int n, m, Q;
    static int[][] d = new int[N][N];

    private static void floyd() {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Q = scan.nextInt();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;

        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt(), w = scan.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }

        floyd();

        while (Q-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt();

            if (d[a][b] > INF / 2) System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
    }
}
