package _0868;

import java.util.Scanner;

/**
 * Date: 2021/1/8 14:52
 * Content:
 */
public class Main2 {

    public static final int N = 1000010;

    static int cnt = 0;
    static int[] p = new int[N];  // 从前往后存储素数，p[j] = i 说明 i 是素数
    static boolean[] st = new boolean[N];  // st[x]存储x是否被筛掉，为true代表是合数

    // 线性筛法求素数  O(n)
    private static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) p[cnt++] = i;
            for (int j = 0; p[j] <= n / i; j++) {
                st[p[j] * i] = true;
                if (i % p[j] == 0) break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        getPrimes(n);
        System.out.println(cnt);
    }
}
