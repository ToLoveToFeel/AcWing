package _0835;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/29 18:53
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int[][] son = new int[N][26];  // 存储树中每个节点的子节点
    public static int[] cnt = new int[N];  // 存储以每个节点结尾的单词数量
    public static int idx;  // 0号点既是根节点，又是空节点

    private static void insert(String s) {

        int p = 0;
        for (char c : s.toCharArray()) {
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;  // 如果 p 不存在孩子 u, 则创建
            p = son[p][u];
        }
        cnt[p]++;
    }

    private static int query(String s) {

        int p = 0;
        for (char c : s.toCharArray()) {
            int u = c - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }

        return cnt[p];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- != 0) {
            String[] t = br.readLine().split(" ");
            String op = t[0], s = t[1];
            if (op.equals("I")) insert(s);
            else System.out.println(query(s));
        }
    }
}
