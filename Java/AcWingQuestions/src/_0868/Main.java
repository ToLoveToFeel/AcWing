package _0868;

import java.util.Scanner;

/**
 * Date: 2021/1/8 14:52
 * Content:
 */
public class Main {

    public static final int N = 1000010;

    static int cnt = 0;
    static boolean[] st = new boolean[N];  // st[x]存储x是否被筛掉，为true代表是合数

    private static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (st[i]) continue;  // 只需要筛除质数的倍数即可
            cnt++;
            for (int j = i + i; j <= n; j += i) st[j] = true;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        getPrimes(n);
        System.out.println(cnt);
    }
}
