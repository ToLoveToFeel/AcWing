package _0898;

import java.util.Scanner;

/**
 * Date: 2021/1/11 16:52
 * Content:
 */
public class Main {

    public static int N = 510;

    static int n;
    static int[][] f = new int[N][N];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                f[i][j] = scan.nextInt();
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++)
                f[i][j] += Math.max(f[i + 1][j], f[i + 1][j + 1]);
        }
        System.out.println(f[1][1]);
    }
}
