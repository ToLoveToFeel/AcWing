package _0795;

import java.util.Scanner;

/**
 * Date: 2020/12/25 11:26
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 数组长度
        int m = scan.nextInt();  // 查询个数
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = scan.nextInt();

        // 算法代码
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++)
            s[i] = s[i - 1] + a[i];

        while (m-- != 0) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
