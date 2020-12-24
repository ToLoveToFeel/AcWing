package _0790;

import java.util.Scanner;

/**
 * Date: 2020/12/24 17:43
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();

        double l = -10000.0, r = 10000.0;
        while (r - l > 1e-8) {  // 精度比所求精度高 2位
            double mid = (l + r) / 2;
            if (mid * mid * mid >= x)
                r = mid;
            else
                l = mid;
        }
        System.out.println(String.format("%.6f", l));
    }
}
