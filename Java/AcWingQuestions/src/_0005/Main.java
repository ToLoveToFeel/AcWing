package _0005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/25 18:26
 * Content: 时间复杂度：O(N*log2(max(s)) * V)      N是物品的数量，s是物品的数量，V是体积
 */
public class Main {

    // 拆分后的物品重量和价值
    private static class Good {
        private int volume;
        private int value;

        public Good(int volume, int value) {
            this.volume = volume;
            this.value = value;
        }
    }

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
        // 数据预处理，将每个物品进行拆分
        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int volume = v[i];
            int value = w[i];
            int num = s[i];
            for (int k = 1; k <= num; k *= 2) {
                num -= k;
                goods.add(new Good(volume * k, value * k));
            }
            if (num > 0) {
                goods.add(new Good(volume * num, value * num));
            }
        }
        // 此时，上述问题已经转化为 0-1背包问题
        int[] dp = new int[V + 1];
        for (Good good : goods) {
            for (int j = V; j >= good.volume; j--) {
                dp[j] = Math.max(dp[j], dp[j - good.volume] + good.value);
            }
        }

        System.out.println(dp[V]);
    }
}
