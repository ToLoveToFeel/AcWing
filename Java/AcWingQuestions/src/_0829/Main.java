package _0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 19:10
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int[] q = new int[N];  // 队列，从q[0]开始存储元素
    public static int hh = 0;  // 队首
    public static int tt = -1;  // 队尾

    private static void push(int x) {
        q[++tt] = x;
    }

    private static void pop() {
        if (hh <= tt)
            hh++;
    }

    private static boolean empty() {
        return hh > tt;
    }

    private static int query() {
        return q[hh];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        while (m-- != 0) {
            int x;
            String op;

            String[] t = br.readLine().split(" ");
            op = t[0];
            if (op.equals("push")) {
                x = Integer.parseInt(t[1]);
                push(x);
            } else if (op.equals("pop")) {
                pop();
            } else if (op.equals("empty")) {
                if (empty()) System.out.println("YES");
                else System.out.println("NO");
            } else {
                System.out.println(query());
            }
        }
        br.close();
    }
}
