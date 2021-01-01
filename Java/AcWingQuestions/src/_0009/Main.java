package _0009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2020/12/27 10:30
 * Content:
 */
public class Main {

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // 物品组数
        int V = scan.nextInt();  // 背包容量
        List<List<Integer>> volumes = new ArrayList<>();  // volumes.get(0) 代表第0组物品的体积
        List<List<Integer>> values = new ArrayList<>();  // values.get(0) 代表第0组物品的价值
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();  // 该组内物品类别数量
            List<Integer> volume = new ArrayList<>();
            List<Integer> value = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                volume.add(scan.nextInt());
                value.add(scan.nextInt());
            }
            volumes.add(volume);
            values.add(value);
        }

        // 算法代码
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {  // 遍历组别
            for (int j = V; j >= 0; j--) {  // 遍历体积
                int num = volumes.get(i).size();  // 组内物品数量
                for (int k = 0; k < num; k++)  // 遍历决策
                    if (j >= volumes.get(i).get(k))
                        dp[j] = Math.max(dp[j], dp[j - volumes.get(i).get(k)] + values.get(i).get(k));
            }
        }

        System.out.println(dp[V]);
    }
}
