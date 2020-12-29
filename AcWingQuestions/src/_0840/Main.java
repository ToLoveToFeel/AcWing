package _0840;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Date: 2020/12/29 22:10
 * Content: 一般哈希：拉链法
 */
public class Main {

    public static final int N = 100003;

    public static int[] h = new int[N];  // 存储链表头指针
    public static int[] e = new int[N];  // 存储数据
    public static int[] ne = new int[N];  // 存储链表指针
    public static int idx;

    // 向哈希表插入元素
    private static void insert(int x) {

        int k = (x % N + N) % N;  // + N 是为了处理余数为负的情况
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    // 寻找哈希表中是否存在x
    private static boolean find(int x) {

        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i])
            if (e[i] == x)
                return true;

        return false;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(h, -1);  // 初始化链表头

        while (n-- != 0) {
            String[] t = br.readLine().split(" ");
            String op = t[0];
            int x = Integer.parseInt(t[1]);
            if (op.equals("I")) insert(x);
            else {
                if (find(x)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
