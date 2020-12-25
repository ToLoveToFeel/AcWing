package _01_BasicAlgorithm._03_highprecision.div;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/25 10:57
 * Content:
 */
public class Main {

    private static int r;  // 余数

    // A / b , 商是C，余数是 r
    private static List<Integer> div(List<Integer> A, int b) {

        List<Integer> C = new ArrayList<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            r = r * 10 + A.get(i);
            C.add(r / b);
            r %= b;
        }

        Collections.reverse(C);
        // 去掉前导0
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);
        return C;
    }

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        int b = scan.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');

        // 算法代码
        List<Integer> C = div(A, b);

        for (int i = C.size() - 1; i >= 0; i--) System.out.print(C.get(i));

        System.out.println();
        System.out.print(r);
    }
}
