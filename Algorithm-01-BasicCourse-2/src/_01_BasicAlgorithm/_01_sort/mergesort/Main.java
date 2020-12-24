package _01_BasicAlgorithm._01_sort.mergesort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/24 15:58
 * Content:
 */
public class Main {

    public static int[] tmp;  // 辅助数组

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void mergeSort(int[] arr, int l, int r) {

        if (l >= r) return;

        int mid = (r - l) / 2 + l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];

        for (i = l, j = 0; i <= r; i++, j++) arr[i] = tmp[j];
    }

    public static void main(String[] args) throws Exception {

        // 读入数据
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int n = Integer.parseInt(br.readLine());  // 数据个数
        tmp = new int[n];
        int[] arr = new int[n];
        String[] t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(t[i]);
        }
        br.close();
        isr.close();

        // 算法代码
        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
