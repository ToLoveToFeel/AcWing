package _0831;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 20:15
 * Content: 模板题
 * 算法正确，但是Java会超时，C++不会!!!
 * 	Time Limit Exceeded
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String t = br.readLine();
        char[] p = new char[n + 1];
        for (int i = 1; i <= n; i++) p[i] = t.charAt(i - 1);

        int m = Integer.parseInt(br.readLine());
        t = br.readLine();
        char[] s = new char[m + 1];
        for (int i = 1; i <= m; i++) s[i] = t.charAt(i - 1);

        // 算法代码
        int[] next = new int[n + 1];
        // 求next的过程
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        // kmp 匹配过程
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                System.out.print((i - n) + " ");
                j = next[j];
            }
        }
    }
}
