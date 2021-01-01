package _01_BasicAlgorithm._03_highprecision.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/25 9:57
 * Content:
 */
public class Main {

    // 判断是否有 A >= B
    private static boolean cmp(List<Integer> A, List<Integer> B) {

        if (A.size() != B.size()) return A.size() > B.size();
        for (int i = A.size() - 1; i >= 0; i--)
            if (A.get(i) != B.get(i))
                return A.get(i) > B.get(i);
        return true;
    }

    // C = A - B
    private static List<Integer> sub(List<Integer> A, List<Integer> B) {

        List<Integer> C = new ArrayList<>();
        int t = 0;  // 借位
        for (int i = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            C.add((t + 10) % 10);
            if (t < 0) t = 1;
            else t = 0;
        }
        // 去除前导零
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);

        return C;
    }

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');

        // 算法代码
        List<Integer> C;
        if (cmp(A, B)) {
            C = sub(A, B);
        } else {
            C = sub(B, A);
            System.out.print("-");
        }

        for (int i = C.size() - 1; i >= 0; i--)
            System.out.print(C.get(i));
    }
}
