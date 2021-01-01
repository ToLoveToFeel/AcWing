package _0838;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/29 19:41
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int[] h = new int[N];  // h数组中存储的是数据
    public static int size;  // 数组大小

    private static void swap(int a, int b) {
        int t = h[a];
        h[a] = h[b];
        h[b] = t;
    }

    private static void down(int u) {

        // 寻找左右孩子中较小的那个
        int t = u;
        if (2 * u <= size && h[2 * u] < h[t]) t = 2 * u;
        if (2 * u + 1 <= size && h[2 * u + 1] < h[t]) t = 2 * u + 1;
        if (u != t) {
            swap(u, t);
            down(t);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        size = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        t = br.readLine().split(" ");
        for (int i = 1; i <= size; i++) h[i] = Integer.parseInt(t[i - 1]);

        // 筛选法建堆
        for (int i = size / 2; i >= 1; i--) down(i);

        while (m-- != 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size];
            size--;
            down(1);
        }
    }
}
