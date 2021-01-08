package _0872;

import java.util.Scanner;

/**
 * Date: 2021/1/8 18:54
 * Content:
 */
public class Main {

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            System.out.println(gcd(a, b));
        }
    }
}
