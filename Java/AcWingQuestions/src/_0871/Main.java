package _0871;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Date: 2021/1/8 18:46
 * Content:
 */
public class Main {

    public static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Map<Integer, Integer> cnt = new HashMap<>();  // (质因子，质因子个数)
        while (n-- != 0) {
            int x = scan.nextInt();
            for (int i = 2; i <= x / i; i++)
                while (x % i == 0) {
                    x /= i;
                    cnt.put(i, cnt.getOrDefault(i, 0) + 1);
                }
            if (x > 1) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        long res = 1;
        for (Integer t : cnt.keySet()) {
            int p = t, a = cnt.get(p);
            long s = 1;
            while (a-- != 0) s = (s * p + 1) % MOD;  // 秦九韶算法
            res = res * s % MOD;
        }

        System.out.println(res);
    }
}
