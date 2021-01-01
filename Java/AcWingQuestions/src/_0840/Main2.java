package _0840;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Date: 2020/12/29 22:10
 * Content: 一般哈希：开放寻址法
 */
public class Main2 {

    public static final int N = 200003;
    public static final int NULL = 0x3f3f3f3f;

    public static int[] h = new int[N];  // 存储链表头指针

    // 如果x在哈希表中，返回x的下标；如果x不在哈希表中，返回x应该插入的位置
    private static int find(int x) {

        int t = (x % N + N) % N;
        while (h[t] != NULL && h[t] != x) {
            t++;
            if (t == N) t = 0;
        }

        return t;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(h, NULL);  // 初始化链表头

        while (n-- != 0) {
            String[] t = br.readLine().split(" ");
            String op = t[0];
            int x = Integer.parseInt(t[1]);

            int k = find(x);
            if (op.equals("I")) h[k] = x;
            else {
                if (h[k] != NULL) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
