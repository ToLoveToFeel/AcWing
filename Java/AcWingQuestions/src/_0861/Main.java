package _0861;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2021/1/7 22:33
 * Content:
 */
public class Main {

    public static final int N = 510, M = 100010;

    static int n1, n2, m;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static int idx;
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean find(int x) {
        // 遍历自己喜欢的女孩
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {  // 如果在这一轮模拟匹配中,这个女孩尚未被预定
                st[j] = true;  // 那x就预定这个女孩了
                // 如果女孩j没有男朋友，或者她原来的男朋友能够预定其它喜欢的女孩。配对成功
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        // 自己中意的全部都被预定了。配对失败。
        return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n1 = scan.nextInt();
        n2 = scan.nextInt();
        m = scan.nextInt();

        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
        }

        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) res++;
        }

        System.out.println(res);
    }
}
