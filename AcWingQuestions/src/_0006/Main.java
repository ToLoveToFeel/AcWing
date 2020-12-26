package _0006;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Date: 2020/12/26 17:58
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品数量
        int V = scan.nextInt();  // 背包容量
        int[] v = new int[N];  // 物品的体积
        int[] w = new int[N];  // 物品的价值
        int[] s = new int[N];  // 物品的数量
        for (int i = 0; i < N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }
        scan.close();

        // 算法代码
        int[] pre = new int[V + 1];
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            System.arraycopy(dp, 0, pre, 0, dp.length);
            int volume = v[i];  // 体积
            int value = w[i];  // 价值
            int num = s[i];  // 数量

            for (int r = 0; r < volume; r++) {
                Deque<Integer> q = new ArrayDeque<>();
                for (int k = r; k <= V; k += volume) {
                    if (!q.isEmpty() && k - num * volume > q.getFirst()) q.removeFirst();
                    int cur = pre[k] - (k - r) / volume * value;
                    while (!q.isEmpty() && pre[q.getLast()] - (q.getLast() - r) / volume * value <= cur)
                        q.removeLast();
                    q.addLast(k);
                    dp[k] = pre[q.getFirst()] + (k - q.getFirst()) / volume * value;
                }
            }
        }

        System.out.println(dp[V]);
    }
}
