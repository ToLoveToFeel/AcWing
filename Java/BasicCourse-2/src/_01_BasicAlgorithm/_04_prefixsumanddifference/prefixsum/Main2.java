package _01_BasicAlgorithm._04_prefixsumanddifference.prefixsum;

/**
 * Date: 2020/12/25 11:15
 * Content: 二维前缀和, 这里a[1][1]表示第一个元素
 * s[i, j] : 第 i 行，第 j 列格子左上部分所有元素之和
 * s[i, j] = s[i - 1, j] + s[i, j - 1] - s[i - 1, j - 1] + a[i][j]
 * 以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵的和为：S[x2, y2] - S[x1 - 1, y2] - S[x2, y1 - 1] + S[x1 - 1, y1 - 1]
 */
public class Main2 {

    public static void main(String[] args) {

        int[][] a = new int[10][10];
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 4; j++)
                a[i][j] = 1;
        // 计算前缀和
        int[][] s = new int[10][10];
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 4; j++)
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
        // 查询从 2,2 到 3,4元素之和
        int x1 = 2, y1 = 2;
        int x2 = 3, y2 = 4;
        System.out.println(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]);
    }
}
