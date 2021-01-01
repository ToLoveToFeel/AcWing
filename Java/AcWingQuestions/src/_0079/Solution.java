package _0079;

import java.util.Arrays;

/**
 * Date: 2020/12/27 19:59
 * Content: 对应 Leetcode 0239 滑动窗口最大值
 */
public class Solution {

    public static final int N = 1000010;

    public static int[] q = new int[N];

    public int[] maxInWindows(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        int hh = 0, tt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) res[index++] = nums[q[hh]];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = (new Solution()).maxInWindows(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
