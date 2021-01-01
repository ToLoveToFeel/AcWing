package _0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 19:21
 * Content: 模板题
 */
public class Main {

    public static final int N = 100010;

    public static int[] stk = new int[N];
    public static int tt = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] t = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(t[i]);

            while (tt != 0 && stk[tt] >= x) tt--;

            if (tt != 0) System.out.print(stk[tt] + " ");
            else System.out.print("-1 ");

            stk[++tt] = x;
        }
    }
}
