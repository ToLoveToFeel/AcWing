package _0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 17:57
 * Content: 模板题
 */
public class Main {

    public static final int N = 100010;

    public static int[] stk = new int[N];  // stk[1]存储第一个元素
    public static int tt = 0;  // 表示栈顶

    private static void push(int x) {
        stk[++tt] = x;
    }

    private static void pop() {
        if (tt > 0)
            tt--;
    }

    private static boolean empty() {
        return tt == 0;
    }

    private static int query() {
        return stk[tt];
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
