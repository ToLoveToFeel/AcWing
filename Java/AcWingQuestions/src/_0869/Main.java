package _0869;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2021/1/8 18:09
 * Content:
 */
public class Main {

    private static List<Integer> getDivisors(int x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= x / i; i++)
            if (x % i == 0) {
                res.add(i);
                if (i != x / i) res.add(x / i);
            }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n-- != 0) {
            int x = scan.nextInt();
            List<Integer> res = getDivisors(x);
            for (Integer t : res) System.out.print(t + " ");
            System.out.println();
        }
    }
}
