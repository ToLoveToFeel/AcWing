package _796;

import java.util.Scanner;

/**
 * Date: 2020/12/25 12:02
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 矩阵行数
        int m = scan.nextInt();  // 矩阵列数
        int q = scan.nextInt();  // 查询数
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                a[i][j] = scan.nextInt();

        // 算法代码
        // 计算前缀和
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
        // 计算查询结果
        while (q-- != 0) {
            int x1 = scan.nextInt(), y1 = scan.nextInt();
            int x2 = scan.nextInt(), y2 = scan.nextInt();
            System.out.println(s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]);
        }
    }
}
