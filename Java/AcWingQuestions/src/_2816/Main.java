package _2816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 14:14
 * Content:
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int[] a = new int[n];
        int[] b = new int[m];
        t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(t[i]);
        t = br.readLine().split(" ");
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(t[i]);
        br.close();

        // 算法代码
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) i++;
            j++;
        }
        if (i == n) System.out.println("Yes");
        else System.out.println("No");
    }
}
