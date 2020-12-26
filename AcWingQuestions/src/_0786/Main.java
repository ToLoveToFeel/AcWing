package _0786;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/26 18:53
 * Content:
 */
public class Main {

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int quickSort(int[] arr, int l, int r, int k) {

        if (l == r) return arr[l];

        int x = arr[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i] < x) ;
            while (arr[--j] > x) ;
            if (i < j) swap(arr, i, j);
        }

        int sl = j - l + 1;  // 左边数据个数
        if (k <= sl) return quickSort(arr, l, j, k);
        return quickSort(arr, j + 1, r, k - sl);
    }

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);  // 数据个数
        int k = Integer.parseInt(t[1]);  // 第 k 小的数据
        t = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(t[i]);
        br.close();

        // 算法代码
        System.out.println(quickSort(arr, 0, n - 1, k));
    }
}
