package _0837;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/29 19:28
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int[] p = new int[N];  // p[x] = t, 代表x指向t
    public static int[] size = new int[N];  // size[x] = s, 代表x所在的等价类大小为s

    // 返回x的根节点
    private static int find(int x) {

        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        // 并查集初始化
        for (int i = 0; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        while (m-- != 0) {
            t = br.readLine().split(" ");
            String op = t[0];

            if (op.equals("C")) {
                int a = Integer.parseInt(t[1]), b = Integer.parseInt(t[2]);
                int pa = find(a), pb = find(b);
                if (pa == pb) continue;
                size[pb] += size[pa];
                p[pa] = pb;  // 并
            } else if (op.equals("Q1")) {  // 查
                int a = Integer.parseInt(t[1]), b = Integer.parseInt(t[2]);
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            } else {
                int a = Integer.parseInt(t[1]);
                System.out.println(size[find(a)]);
            }
        }
    }
}
