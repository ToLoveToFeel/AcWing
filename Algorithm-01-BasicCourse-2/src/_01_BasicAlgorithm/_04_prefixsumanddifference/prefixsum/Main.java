package _01_BasicAlgorithm._04_prefixsumanddifference.prefixsum;

/**
 * Date: 2020/12/25 11:15
 * Content: 一维前缀和
 * s[i] : 代表原数组 a 中前 i 个元素的和
 * s[i] = a[0] + a[1] + ... + a[i-1]
 * 计算 a 中第 l 个数到第 r 个数的和(第1个数对应 a[0]) : s[r] - s[l - 1] = a[l] + ... + a[r-1]
 * 为了方便理解，输入数据a的第一个元素可以从a[1]开始，a[0]空着
 */
public class Main {

    public static void main(String[] args) {

        int[] a = {2, 1, 3, 6, 4};
        int[] s = new int[a.length + 1];
        for (int i = 1; i <= a.length; i++) {
            s[i] = s[i - 1] + a[i - 1];
        }

        // 计算第2个数到第5个数之和 : a[1] + ... + a[4]
        System.out.println(s[5] - s[2 - 1]);
    }
}
