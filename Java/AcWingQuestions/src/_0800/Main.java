package _0800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 13:46
 * Content: 时间复杂度 : O(n*m)
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int x = Integer.parseInt(t[2]);
        int[] A = new int[n];
        int[] B = new int[m];
        t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(t[i]);
        t = br.readLine().split(" ");
        for (int i = 0; i < m; i++) B[i] = Integer.parseInt(t[i]);

        // 算法代码
        for (int i = 0, j = m - 1; i < n; i++) {
            while (j >= 0 && A[i] + B[j] > x) j--;
            if (A[i] + B[j] == x) {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
