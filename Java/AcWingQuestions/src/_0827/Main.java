package _0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/27 17:25
 * Content: 模板题
 */
public class Main {

    public static final int N = 100010;

    public static int[] e = new int[N];
    public static int[] l = new int[N];
    public static int[] r = new int[N];
    public static int idx;

    // 初始化
    private static void init() {
        // 0表示左端点，1表示右端点；不用于作为存储数据的索引
        r[0] = 1;  // 0指向1, 首指向尾
        l[1] = 0;  // 1指向0，尾指向首
        idx = 2;
    }

    // 在下标是k的点的右边，插入x (k从2开始，如果要删除插入的第5个数，则k=6)
    private static void add(int k, int x) {
        e[idx] = x;  // 存储元素, idx是为元素x分配的下标
        r[idx] = r[k];  // x指向k的右侧点
        l[idx] = k;  // x指向k
        l[r[k]] = idx;  // k的后继的前驱指向idx
        r[k] = idx;  // k指向idx
        idx++;
    }

    // 删除下标为k对应的数 (k从2开始，如果要删除插入的第5个数，则k=6)
    private static void remove(int k) {
        r[l[k]] = r[k];  // k的前驱指向k的后继
        l[r[k]] = l[k];  // k的后继指向k的前驱
    }

    // 在链表的最左端插入数据x
    private static void addToHead(int x) {
        add(0, x);
    }

    // 在链表的最有端插入数据x
    private static void addToTail(int x) {
        add(l[1], x);
    }

    // 在下标是k的点的左边，插入x (k从2开始，如果要删除插入的第5个数，则k=6)
    private static void addLeft(int k, int x) {
        add(l[k], x);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        init();

        while (m-- != 0) {
            int k, x;
            String op;

            String[] t = br.readLine().split(" ");
            op = t[0];
            if (op.equals("L")) {
                x = Integer.parseInt(t[1]);
                addToHead(x);
            } else if (op.equals("R")) {
                x = Integer.parseInt(t[1]);
                addToTail(x);
            } else if (op.equals("D")) {
                k = Integer.parseInt(t[1]);
                remove(k + 1);
            } else if (op.equals("IL")) {
                k = Integer.parseInt(t[1]);
                x = Integer.parseInt(t[2]);
                addLeft(k + 1, x);
            } else {
                k = Integer.parseInt(t[1]);
                x = Integer.parseInt(t[2]);
                add(k + 1, x);
            }
        }
        br.close();

        for (int i = r[0]; i != 1; i = r[i]) System.out.print(e[i] + " ");
    }
}
