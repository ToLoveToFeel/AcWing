package _01_BasicAlgorithm._03_highprecision.mul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/25 10:36
 * Content:
 */
public class Main {

    // C = A * b
    private static List<Integer> mul(List<Integer> A, int b) {

        List<Integer> C = new ArrayList<>();
        int t = 0;  // 进位
        for (int i = 0; i < A.size() || t != 0; i++) {
            if (i < A.size()) t += A.get(i) * b;
            C.add(t % 10);
            t /= 10;
        }
        // 去除前导0
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
        List<Integer> C = mul(A, b);

        for (int i = C.size() - 1; i >= 0; i--) System.out.print(C.get(i));
    }
}
