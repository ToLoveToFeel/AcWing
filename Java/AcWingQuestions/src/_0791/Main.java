package _0791;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/24 22:07
 * Content:
 */
public class Main {

    private static List<Integer> add(List<Integer> A, List<Integer> B) {

        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size() || i < B.size(); i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        if (t != 0) C.add(1);

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

        List<Integer> C = add(A, B);

        for (int i = C.size() - 1; i >= 0; i--)
            System.out.print(C.get(i));
    }
}
