package _0007;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/26 20:15
 * Content:
 */
public class Main {

    // 拆分后的物品重量和价值
    private static class Good {
        private int kind;  // 物品的种类
        private int volume;  // 容量
        private int value;  // 价值

        public Good(int kind, int volume, int value) {
            this.kind = kind;
            this.volume = volume;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        // 读取数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品种类数目
        int V = scan.nextInt();  // 背包容量
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];  // 物品个数，-1代表01背包，0代表完全背包
        for (int i = 0; i < N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }

        // 算法代码
        // 数据预处理，将多重背包中的物品进行拆分
        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int volume = v[i];
            int value = w[i];
            int num = s[i];

            if (num == -1) goods.add(new Good(-1, volume, value));
            else if (num == 0) goods.add(new Good(0, volume, value));
            else {  // 完全背包转换为01背包
                for (int k = 1; k <= num; k *= 2) {
                    num -= k;
                    goods.add(new Good(-1, volume * k, value * k));
                }
                if (num > 0) goods.add(new Good(-1, volume * num, value * num));
            }
        }
        // 判断物品的类别，按照物品的类别进行状态转移即可
        int[] dp = new int[V + 1];
        for (Good good : goods) {
            if (good.kind == -1) {
                for (int j = V; j >= good.volume; j--)
                    dp[j] = Math.max(dp[j], dp[j - good.volume] + good.value);
            } else {
                for (int j = good.value; j <= V; j++)
                    dp[j] = Math.max(dp[j], dp[j - good.volume] + good.value);
            }
        }

        System.out.println(dp[V]);
    }
}
