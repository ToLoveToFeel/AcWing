package _01_BasicAlgorithm._01_sort.quicksort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/24 14:42
 * Content:
 */
public class Main {

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void quickSort(int[] arr, int l, int r) {

        if (l >= r) return;

        int x = arr[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {  // 双指针
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);
            if (i < j) swap(arr, i, j);
        }

        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }

    private static void quickSort2(int[] arr, int l, int r) {

        if (l >= r) return;

        int x = arr[(l + r + 1) >> 1], i = l - 1, j = r + 1;
        while (i < j) {  // 双指针
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);
            if (i < j) swap(arr, i, j);
        }

        quickSort2(arr, l, i - 1);
        quickSort2(arr, i, r);
    }

    private static void quickSort3(int[] arr, int l, int r) {

        if (l >= r) return;

        int x = arr[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {  // 双指针
            while (arr[++i] < x) ;
            while (arr[--j] > x) ;
            if (i < j) swap(arr, i, j);
        }

        quickSort3(arr, l, j);
        quickSort3(arr, j + 1, r);
    }

    public static void main(String[] args) throws Exception {

        // 读入数据
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int n = Integer.parseInt(br.readLine());  // 数据个数
        int[] arr = new int[n];
        String[] t = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(t[i]);
        br.close();
        isr.close();

        // 算法代码
        quickSort3(arr, 0, n - 1);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
