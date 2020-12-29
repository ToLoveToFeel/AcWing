package _0841;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/29 22:29
 * Content:
 */
public class Main {

    public static final int N = 100010;
    public static final int P = 131;  // 13331

    public static long[] h = new long[N];
    public static long[] p = new long[N];

    private static long get(int l, int r) {

        return h[r] - h[l - 1] * p[r - l + 1];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);  // 字符串长度
        int m = Integer.parseInt(t[1]);  // 查询个数
        char[] str = br.readLine().toCharArray();

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + str[i - 1];
        }

        while (m-- != 0) {
            t = br.readLine().split(" ");
            int l1 = Integer.parseInt(t[0]), r1 = Integer.parseInt(t[1]);
            int l2 = Integer.parseInt(t[2]), r2 = Integer.parseInt(t[3]);

            if (get(l1, r1) == get(l2, r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
