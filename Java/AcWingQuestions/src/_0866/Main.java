package _0866;

import java.util.Scanner;

/**
 * Date: 2021/1/8 14:14
 * Content:
 */
public class Main {

    private static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++)
            if (x % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n-- != 0) {
            int x = scan.nextInt();
            if (isPrime(x)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
