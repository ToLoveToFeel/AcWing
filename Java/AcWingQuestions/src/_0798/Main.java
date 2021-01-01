package _0798;

import java.util.Scanner;

/**
 * Date: 2020/12/25 16:31
 * Content:
 * Time Limit Exceeded
 * 普遍Scanner会超时，所以需要使用BufferedReader
 */
public class Main {

    private static int[][] a;
    private static int[][] b;

    private static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 行数
        int m = scan.nextInt();  // 列数
        int q = scan.nextInt();  // 操作个数
        int N = n + 10;
        int M = m + 10;
        a = new int[N][M];
        b = new int[N][M];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                a[i][j] = scan.nextInt();

        // 算法代码
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                insert(i, j, i, j, a[i][j]);
        while (q-- != 0) {
            int x1 = scan.nextInt(), y1 = scan.nextInt();
            int x2 = scan.nextInt(), y2 = scan.nextInt();
            int c = scan.nextInt();
            insert(x1, y1, x2, y2, c);
        }
        // 求前缀和，即更新后的a
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }
}
