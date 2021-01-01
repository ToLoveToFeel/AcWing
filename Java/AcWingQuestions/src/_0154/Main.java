package _0154;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 19:32
 * Content:
 */
public class Main {

    public static final int N = 1000010;

    public static int[] q = new int[N];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int k = Integer.parseInt(t[1]);
        t = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(t[i]);

        // 寻找滑动窗口内最小值
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {

            // 判断队首是否已经划出窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            // 维护单调队列
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            // 当前元素入队
            q[++tt] = i;

            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }

        System.out.println();

        // 寻找滑动窗口内最大值
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {

            // 判断队首是否已经划出窗口
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            // 维护单调队列
            while (hh <= tt && a[q[tt]] <= a[i]) tt--;
            // 当前元素入队
            q[++tt] = i;

            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }
    }
}
