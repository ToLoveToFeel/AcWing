package _02_DataStructure._01_linkedlist.doublel;

/**
 * Date: 2020/12/27 17:12
 * Content:
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

    // 在下标是k的点的右边，插入x
    private static void add(int k, int x) {
        e[idx] = x;  // 存储元素, idx是为元素x分配的下标
        r[idx] = r[k];  // x指向k的右侧点
        l[idx] = k;  // x指向k
        l[r[k]] = idx;  // k的后继的前驱指向idx
        r[k] = idx;  // k指向idx
        idx++;
    }

    // 删除第k个点
    private static void remove(int k) {
        r[l[k]] = r[k];  // k的前驱指向k的后继
        l[r[k]] = l[k];  // k的后继指向k的前驱
    }
}
