package _0867;

import java.util.Scanner;

/**
 * Date: 2021/1/8 14:39
 * Content:
 */
public class Main {

    private static void divide(int x) {
        for (int i = 2; i <= x / i; i++)
            if (x % i == 0) {  // 条件满足的话，i一定是质数
                int s = 0;  // 记录该质因子的个数
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                System.out.println(i + " " + s);
            }
        if (x > 1) System.out.println(x + " 1");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n-- != 0) {
            int x = scan.nextInt();
            divide(x);
            System.out.println();
        }
    }
}
