package _0789;

import java.util.Scanner;

/**
 * Date: 2020/12/24 17:15
 * Content: 模板题
 * 对应Leetcode 0034 在排序数组中查找元素的第一个和最后一个位置
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 数组大小
        int count = scan.nextInt();  // 查询个数
        // 获取完整数组
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }


        // 算法代码
        while (count-- != 0) {
            int target = scan.nextInt();  // 本轮查询的目标值

            // 初始化l和r，查找左边界
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (arr[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            // 跳出循环时，l == r
            if (arr[l] != target) {
                System.out.println("-1 -1");
            } else {
                System.out.print(l + " ");
                // 初始化 l和 r, 查找右边界
                l = 0;
                r = n - 1;
                while (l < r) {
                    // 需要上取整，因为下取整mid可能还等于l，导致区间无法更新，陷入死循环
                    int mid = (l + r + 1) >> 1;
                    if (arr[mid] <= target)
                        l = mid;
                    else
                        r = mid - 1;
                }
                System.out.println(r);
            }
        }

    }
}
