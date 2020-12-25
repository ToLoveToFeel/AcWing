package _01_BasicAlgorithm._04_prefixsumanddifference.difference;

import java.util.Scanner;

/**
 * Date: 2020/12/25 14:57
 * Content: 一维差分
 * 从a[1]开始存储数据，a[0]没用
 * a是前缀和数组，b是a对应的差分数组
 * 对a中[l...r]的数据加c，可以变为对 b 的两个操作：b[l] += c, b[r + 1] -= c
 */
public class Main {

    private static int[] a;
    private static int[] b;

    private static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // a中数据个数
        int m = scan.nextInt();  // 操作个数
        a = new int[n + 10];
        b = new int[n + 10];
        for (int i = 1; i <= n; i++) a[i] = scan.nextInt();

        // 算法代码
        for (int i = 1; i <= n; i++) insert(i, i, a[i]);
        while (m-- != 0) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int c = scan.nextInt();
            insert(l, r, c);
        }
        // 求前缀和，即更新后的a
        for (int i = 1; i <= n; i++) b[i] += b[i - 1];

        for (int i = 1; i <= n; i++) System.out.print(b[i] + " ");
    }
}
