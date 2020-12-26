package _0799;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/26 21:09
 * Content:
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 数据数量
        String[] t = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(t[i]);

        // 算法代码
        int[] hash = new int[100000 + 10];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {  // j在左边，i在右边
            hash[arr[i]]++;
            while (hash[arr[i]] >= 2) {
                hash[arr[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }

        System.out.println(res);
    }
}
