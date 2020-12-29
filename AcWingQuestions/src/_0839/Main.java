package _0839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 2020/12/29 20:10
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int[] h = new int[N];  // h数组中存储的是数据
    public static int size;  // 数组大小

    public static int[] ph = new int[N];  // pointer heap, ph[k] : 第k个插入(从1开始)的点在堆中的位置
    public static int[] hp = new int[N];  // heap pointer, hp[k] : 堆中下标是k的点是第几个插入的

    private static void heapSwap(int a, int b) {
        swap(h, a, b);  // 交换h[a]和h[b], 这里是真实的数据交换
        swap(ph, hp[a], hp[b]);  // 因为数据发生了交换，所以要将下标为 a 和下标为 b 的点插入次序(第几个插入的)交换
        swap(hp, a, b);  // 维持 a 和 b 第几次插入的
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private static void down(int u) {

        // 寻找左右孩子中较小的那个
        int t = u;
        if (2 * u <= size && h[2 * u] < h[t]) t = 2 * u;
        if (2 * u + 1 <= size && h[2 * u + 1] < h[t]) t = 2 * u + 1;
        if (u != t) {
            heapSwap(u, t);
            down(t);
        }
    }

    private static void up(int u) {

        while (u / 2 != 0 && h[u / 2] > h[u]) {
            heapSwap(u / 2, u);
            u /= 2;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = 0;  // 代表第 m 个插入的数据，从1开始，这里初始化为0，因为后面用到之前会++
        while (n-- != 0) {
            String[] t = br.readLine().split(" ");

            String op = t[0];
            int k, x;
            if (op.equals("I")) {  // 插入
                x = Integer.parseInt(t[1]);
                size++;
                m++;
                ph[m] = size;  // 第m个插入的数据索引为size
                hp[size] = m;  // 索引为size对应的数据是第m个被插入的数据
                h[size] = x;
                up(size);
            } else if (op.equals("PM")) {  // 输出当前集合中的最小值
                System.out.println(h[1]);
            } else if (op.equals("DM")) {  // 删除当前集合中的最小值
                heapSwap(1, size);
                size--;
                down(1);
            } else if (op.equals("D")) {  // 删除第k个插入的数
                k = Integer.parseInt(t[1]);
                int index = ph[k];  // 第k个插入的数在堆中的位置
                heapSwap(index, size);
                size--;
                up(index);
                down(index);
            } else {  // 修改第k个插入的数，将其变为x
                k = Integer.parseInt(t[1]);
                x = Integer.parseInt(t[2]);
                int index = ph[k];
                h[index] = x;
                up(index);
                down(index);
            }
        }
    }
}
