package _0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/26 21:31
 * Content: 模板题
 */
public class Main {

    private static int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] t = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(t[i]);
        br.close();

        // 算法代码
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int res = 0;
            while (x != 0) {
                x -= lowbit(x);
                res++;
            }
            System.out.print(res + " ");
        }
    }
}
