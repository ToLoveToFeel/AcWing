package _02_DataStructure._01_linkedlist.single;

/**
 * Date: 2020/12/27 16:33
 * Content:
 */
public class Main {

    public static final int N = 100010;

    public static int head;  // 表示头结点的下标
    public static int[] e = new int[N];  // e[i] 表示节点i的值
    public static int[] ne = new int[N];  // ne[i] 表示节点i的next指针是多少
    public static int idx;  // 存储当前已经用到了哪个点，从0开始分配

    // 初始化
    private static void init() {
        head = -1;
        idx = 0;
    }

    // 将x插入到头结点
    private static void addToHead(int x) {
        e[idx] = x;  // 存储元素, idx是为元素x分配的下标
        ne[idx] = head;  // x指向head
        head = idx;  // head指向x
        idx++;  // 下一个插入元素应该被分配的索引
    }

    // 将x插到下标是k的点后面
    private static void add(int k, int x) {
        e[idx] = x;  // 存储元素, idx是为元素x分配的下标
        ne[idx] = ne[k];  // x指向k的后继
        ne[k] = idx;  // k的后继为x
        idx++;  // 下一个插入元素应该被分配的索引
    }

    // 将下标是k的点后面的点删掉
    private static void remove(int k) {
        ne[k] = ne[ne[k]];  // 让k指向k的后继的后继
    }

    public static void main(String[] args) {


    }
}
