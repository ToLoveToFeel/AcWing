package _0798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Date: 2020/12/25 16:31
 * Content:
 */
public class Main2 {

    private static int[][] a;
    private static int[][] b;

    private static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) throws Exception {

        // 读入数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);  // 行数
        int m = Integer.parseInt(str[1]);  // 列数
        int q = Integer.parseInt(str[2]);  // 操作个数
        int N = n + 10;
        int M = m + 10;
        a = new int[N][M];
        b = new int[N][M];
        for (int i = 1; i <= n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++)
                a[i][j] = Integer.parseInt(str[j - 1]);
        }

        // 算法代码
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                insert(i, j, i, j, a[i][j]);
        while (q-- != 0) {
            str = reader.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]), y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]), y2 = Integer.parseInt(str[3]);
            int c = Integer.parseInt(str[4]);
            insert(x1, y1, x2, y2, c);
        }
        // 求前缀和，即更新后的a
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];

        // 求b数组的前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                writer.write(b[i][j] + " ");
            }
            writer.write("\n");
        }
        // 所有write下的内容，会先存在writer中，当启用flush以后，会输出存在其中的内容。
        // 如果没有调用flush，则不会将writer中的内容进行输出。
        writer.flush();
        reader.close();
        writer.close();
    }
}
