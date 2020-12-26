package _0788;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/26 19:38
 * Content:
 */
public class Main {

    public static int[] tmp;  // 辅助数组

    private static long mergeSort(int[] arr, int l, int r) {

        if (l >= r) return 0;

        int mid = (r - l) / 2 + l;
        long res = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r);

        // 归并过程
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                res += mid - i + 1;
            }
        }
        // 扫尾
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];
        for (i = l, j = 0; i <= r; i++, j++) arr[i] = tmp[j];

        return res;
    }

    public static void main(String[] args) throws Exception {

        // 读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        tmp = new int[n];
        String[] t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(t[i]);

        // 算法代码
        System.out.println(mergeSort(arr, 0, n - 1));
    }
}
