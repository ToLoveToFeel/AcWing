package _0680;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2021/1/15 19:44
 * Content:
 */
public class Main {

    public static final int N = 10010;

    static int n, m;
    static int[] w = new int[N];

    private static boolean check(double mid) {
        int cnt = 0;
        for (int i = 0; i < n; i++)
            cnt += w[i] / mid;
        return cnt >= m;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);

        t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) w[i] = Integer.parseInt(t[i]);

        double l = 0, r = 1e9;
        while (r - l > 1e-4) {
            double mid = (l + r) / 2;
            if (check(mid)) l = mid;
            else r = mid;
        }

        System.out.println(r);
    }
}
