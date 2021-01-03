package _0850;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Date: 2021/1/3 15:58
 * Content: 堆优化版的Dijkstra算法     O(m*log(n))           适合于稀疏图
 */
public class Main {

    public static final int N = 150010;
    public static int n, m;  // 顶点数，边数
    // 稀疏图，使用邻接表存储
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] w = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;

    public static int[] dist = new int[N];    // 存储起始点(1号点)到其他点的最短距离
    public static boolean[] st = new boolean[N];   // 标记当前点是否已经求出最短距离，默认都是false

    public static class MyPair implements Comparable<MyPair> {
        int first, second;  // (距离，点的编号)

        public MyPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(MyPair o) {
            return this.first - o.first;
        }
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;  // 边(a, b) 的权重为c
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int dijkstra() {

        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;  // 起始点到起始点距离为0

        PriorityQueue<MyPair> heap = new PriorityQueue<>();
        heap.add(new MyPair(0, 1));

        while (!heap.isEmpty()) {
            // 寻找当前距离最小的点
            MyPair t = heap.peek();
            heap.remove();

            // 得到一个解
            int ver = t.second, distance = t.first;
            if (st[ver]) continue;   // 如果当前点已经求出最短距离了，就不需要继续求解了
            st[ver] = true;

            // 用当前得到的解更新其他点的距离
            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];  // 当前考察的是(i,j)这条边
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    heap.add(new MyPair(dist[j], j));
                }
            }
        }

        if (dist[n] == 0x3f3f3f3f) return -1;
        return dist[n];
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // 读入点数，边数
        n = scan.nextInt();
        m = scan.nextInt();

        Arrays.fill(h, -1);
        // 读入所有的边
        while (m-- != 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            add(a, b, c);  // 邻接表可以自动解决自环和重边的问题，不需要特殊处理
        }

        int t = dijkstra();

        System.out.println(t);
    }
}
