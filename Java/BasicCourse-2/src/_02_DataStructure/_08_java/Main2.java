package _02_DataStructure._08_java;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Date: 2021/02/21 21:57
 * Content:
 */
public class Main2 {

    // ArrayList
    @Test
    public void test01() {
        // 定义 ArrayList
        // 定义一个空 ArrayList
        List<Integer> a = new ArrayList<>();
        // 定义一个空 ArrayList，初始容量为3
        List<Integer> b = new ArrayList<>(3);
        // 定义一个包含元素1,2,3 的 ArrayList
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 遍历 ArrayList
        for (int i = 0; i < c.size(); i++) System.out.print(c.get(i) + " ");
        System.out.println();
        for (int x : c) System.out.print(x + " ");
        System.out.println();

        // 获取 ArrayList 第一个和最后一个元素
        System.out.println(c.get(0));  // 第一个元素：c[0]常用
        System.out.println(c.get(c.size() - 1));  // 最后一个元素

        // 在 ArrayList 尾部添加、删除元素
        c.add(4);
        c.remove(c.size() - 1);
        c.remove(c.size() - 1);
        System.out.println(c.size());  // 2

        // 清空 ArrayList
        c.clear();
        System.out.println(c.size());  // 0

        // ArrayList 之间的比较需要自己实现
    }

    // Queue队列
    @Test
    public void test02() {
        // 定义 queue
        Queue<Integer> q = new LinkedList<>();
        // 入队、出队
        q.add(4);  // 4
        q.add(3);  // 4,3
        q.add(7);  // 4,3,7
        q.remove();  // 3,7
        // 获取 queue 队首和队尾元素(无法获取队尾元素)
        System.out.println(q.peek());  // 返回队首元素: 3
        // 清空 queue
        q.clear();
        System.out.println(q.size());  // 0
        System.out.println(q.isEmpty());  // true


        // 定义PriorityQueue
        System.out.println("=======================");
        Queue<Integer> a = new PriorityQueue<>();  // 小根堆
        Queue<Integer> b = new PriorityQueue<>(((o1, o2) -> o2 - o1));  // 大根堆
        class Rec implements Comparable<Rec> {
            int x, y;
            Rec(int x, int y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public int compareTo(Rec o) { return this.x - o.x; }
            @Override
            public String toString() { return "Rec{" + "x=" + x + ", y=" + y + '}'; }
        }
        Queue<Rec> c = new PriorityQueue<>();  // 此时为小根堆
        // PriorityQueue 中插入元素，删除元素
        c.add(new Rec(1, 2));
        c.add(new Rec(6, 7));
        c.add(new Rec(5, 4));
        c.add(new Rec(3, 9));
        c.remove();
        // 返回堆顶元素
        System.out.println(c.peek());  // Rec{x=3, y=9}
    }

    // stk
    @Test
    public void test03() {
        // 定义 stk
        Deque<Integer> stk = new ArrayDeque<>();
        // 入栈，出栈
        stk.push(20); stk.push(10); stk.push(30);
        stk.pop();  // 弹出30
        // 返回栈顶元素
        System.out.println(stk.peek());  // 10
        // 清空 stk
        stk.clear();
        System.out.println(stk.size());  // 0
        System.out.println(stk.isEmpty());  // true
    }

    // Deque
    @Test
    public void test04() {
        // 定义 deque
        Deque<Integer> d = new ArrayDeque<>();
        // 双端队列中插入、删除元素
        d.addLast(20); d.addLast(10);    // 尾部插入数据: 20,10
        d.removeLast();  // 弹出一个尾部数据10: 20
        d.addFirst(40); d.addFirst(30);  // 头部插入数据: 30,40,20
        d.removeFirst();  // 弹出一个头部数据30: 40,20
        // 遍历 deuqe，不能使用fori进行遍历
        for (int x : d) System.out.print(x + " ");
        System.out.println();
        // 返回头部和尾部元素
        System.out.println(d.getFirst());  // 40
        System.out.println(d.getLast());  // 20
        // 清空 deque
        d.clear();
        System.out.println(d.size());  // 0
        System.out.println(d.isEmpty());  // true
    }

    // Set
    @Test
    public void test05() {
        /*
         * 有序的set: TreeSet
         */
        // 定义 set，元素不能重复，TreeSet内部实现是红黑树，可以保持有序
        TreeSet<Integer> a = new TreeSet<>();
        class Rec implements Comparable<Rec> {
            int x, y;
            Rec(int x, int y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public int compareTo(Rec o) { return this.x - o.x; }
        }
        TreeSet<Rec> b = new TreeSet<>();
        // set 中插入、删除元素
        a.add(20); a.add(3); a.add(1);
        a.remove(3);
        // 返回第一个和最后一个元素
        System.out.println(a.first());  // 1
        System.out.println(a.last());  // 20
        // 遍历 set，不能使用fori进行遍历
        for (int x : a) System.out.print(x + " ");
        System.out.println();
        // set 中判断某元素是否存在
        System.out.println(a.contains(20));
        // ceiling/higher
        a.add(4); a.add(12);  // a: 1, 4, 12, 20
        System.out.println(a.ceiling(4));  // 返回大于等于4的最小元素: 4
        System.out.println(a.higher(4));  // 返回大于4的最小元素: 12
        // 补充：floor/lower
        System.out.println(a.floor(4));  // 返回小于等于4的最大元素: 4
        System.out.println(a.lower(4));  // 返回小于4的最大元素: 1
        // 清空 set
        a.clear();
        System.out.println(a.size());  // 0
        System.out.println(a.isEmpty());  // true

        // Java中没有类似于multiset的集合，可以使用TreeMap实现multiset的各项功能


        /*
         * 无序的set: HashSet
         */
        System.out.println("=======================");
        // 定义 set，元素不能重复，HashSet内部实现是哈希表，不可以保持有序
        HashSet<Integer> hash = new HashSet<>();
        // set 中插入、删除元素
        hash.add(1); hash.add(2); hash.add(3); hash.add(4);
        hash.remove(2);
        // 遍历 set，不能使用fori进行遍历
        for (int x : hash) System.out.print(x + " ");
        System.out.println();
        // set 中判断某元素是否存在
        System.out.println(hash.contains(3));  // true
        // 清空 set
        hash.clear();
        System.out.println(hash.size());  // 0
        System.out.println(hash.isEmpty());  // true
    }

    // Map
    @Test
    public void test06() {
        /*
         * 有序的map: TreeMap
         */
        // 定义 map，元素不能重复，内部实现是红黑树，可以保持有序
        TreeMap<String, Integer> a = new TreeMap<>();
        // map 中插入、删除元素
        a.put("wxx", 21); a.put("hh", 18); a.put("other", 20);
        a.remove("other");
        // 返回第一个和最后一个元素
        System.out.println(a.firstEntry());  // hh=18
        System.out.println(a.lastEntry());  // wxx=21
        // 遍历 map
        for (Map.Entry<String, Integer> p : a.entrySet()) System.out.print(p + "\t");
        System.out.println();
        for (String k : a.keySet()) System.out.print(k + ":" + a.get(k) + "\t");
        System.out.println();
        Iterator<Map.Entry<String, Integer>> it = a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            System.out.print(e.getKey() + "~" + e.getValue() + "\t");
        }
        System.out.println();
        // map 中判断某元素是否存在
        System.out.println(a.containsKey("wxx"));  // true
        // ceilingKey/higherKey
        a.put("c1", 2); a.put("c2", 4);  // a: {c1=2, c2=4, hh=18, wxx=21}
        System.out.println(a.ceilingKey("c1"));  // 返回大于等于"c1"的最小元素: c1
        System.out.println(a.higherKey("c1"));  // 返回大于"c1"的最小元素: c2
        // 补充：floorKey/lowerKey
        System.out.println(a.floorKey("c1"));  // 返回小于等于"c1"的最大元素: c1
        System.out.println(a.lowerKey("c1"));  // 返回小于"c1"的最大元素: null
        // 清空 set
        a.clear();
        System.out.println(a.size());  // 0
        System.out.println(a.isEmpty());  // true

        // Java中没有类似于multimap的集合


        /*
         * 无序的map: HashMap
         */
        System.out.println("=======================");
        // 定义 set，元素不能重复，HashSet内部实现是哈希表，不可以保持有序
        HashMap<String, Integer> hash = new HashMap<>();
        // set 中插入、删除元素
        hash.put("wxx", 21); hash.put("hh", 18); hash.put("other", 20);
        hash.remove("other");
        // 遍历 set，不能使用fori进行遍历
        for (Map.Entry<String, Integer> p : hash.entrySet()) System.out.print(p + "\t");
        System.out.println();
        for (String k : hash.keySet()) System.out.print(k + ":" + hash.get(k) + "\t");
        System.out.println();
        // set 中判断某元素是否存在
        System.out.println(hash.containsKey("wxx"));  // true
        // 清空 set
        hash.clear();
        System.out.println(hash.size());  // 0
        System.out.println(hash.isEmpty());  // true
    }

    // BitSet
    // https://www.runoob.com/java/java-bitset-class.html
    @Test
    public void test07() {
        // 定义BitSet
        BitSet a = new BitSet(1000), b = new BitSet(1000);
        // 赋值
        a.set(0, true);  // a[0] = true
        a.set(2, 8, true);  // 将b[2~8)全部设为true
        b.flip(1, 9);  // b[1~9)全部翻转
        // 获取某一位的值
        System.out.println(a.get(3));  // true
        // 位运算
        a.and(b);  // & 与
        a.or(b);  // | 或
        a.xor(b);  // ^ 异或
        // 返回此 BitSet 表示位值时实际使用空间的位数。
        System.out.println(a.size());
    }

    // Pair
    @Test
    public void test08() {
        // 系统库中的Pair(javafx.util.Pair)
        Pair<Integer, Integer> pair = new Pair<>(1, 1);
        pair.getKey();
        pair.getValue();

        // 有些jdk中不包含Pair，比如zulu(https://www.azul.com/)家的jdk，因此推荐自己写一个
        class MyPair implements Comparable<MyPair> {
            int x, y;

            public MyPair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(MyPair o) {
                if (x != o.x) return x - o.x;
                else return y - o.y;
            }
        }
        MyPair a = new MyPair(1, 2), b = new MyPair(3, 1);
        System.out.println(a.compareTo(b));  // -2
        // 输出MyPair
        System.out.println("(" + a.x + ", " + a.y + ")");
    }

    // 翻转
    @Test
    public void test09() {

        // 翻转 ArrayList
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.reverse(a);
        System.out.println(a);

        // 翻转 String
        String s = "abcd";
        s = new StringBuilder(s).reverse().toString();
        System.out.println(s);

        // 翻转数组：不存在库函数
        int[] b = {1, 2, 3, 4, 5};
        for (int l = 0, r = b.length - 1; l < r; l++, r--) {
            int t = b[l]; b[l] = b[r]; b[r] = t;
        }
        System.out.println(Arrays.toString(b));
    }

    // 去重
    @Test
    public void test10() {

        // 数组去重
        int[] a = {1, 1, 2, 2, 3, 3, 4};
        int m = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || a[i] != a[i - 1])
                a[m++] = a[i];
        }
        for (int i = 0; i < m; i++) System.out.print(a[i] + " ");
        System.out.println();

        // ArrayList 去重
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4));
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            if (i == 0 || !b.get(i).equals(b.get(i - 1)))
                res.add(b.get(i));
        }
        System.out.println(res);
    }

    // 随机打乱
    @Test
    public void test11() {

        // 打乱数组: 实现比较麻烦，思路是先将数组转为List，然后打乱，然后再转为数组
        int[] a = {1, 2 , 3, 4, 5};
        /*
         * int[] 转 List<Integer>
         * 1.使用 Arrays.stream 将 int[] 转换成 IntStream。
         * 2.使用 IntStream中 的 boxed() 装箱。将 IntStream 转换成 Stream<Integer>。
         * 3.使用 Stream 的 collect()，将 Stream<T> 转换成 List<T>，因此正是 List<Integer>。
         */
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        /*
         * List<Integer> 转 int[]
         * 1.想要转换成 int[] 类型，就得先转成 IntStream。
         *   这里就通过 mapToInt() 把 Stream<Integer> 调用 Integer::valueOf 来转成 IntStream
         * 2.而 IntStream 中默认 toArray() 转成 int[]。
         */
        a = list.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(a));


        // 打乱 ArrayList
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 2 , 3, 4, 5));
        Collections.shuffle(b);
        System.out.println(b);
    }

    // sort
    @Test
    public void test12() {

        // 对数组进行排序
        int[] a = {3, 1, 4, 5, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        // 对 ArrayList 排序
        System.out.println("=======================");
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(3, 1, 4, 5, 2));
        Collections.sort(t);
        System.out.println(t);

        // 对自定义的类排序
        // 两种方式：(1) 传入比较函数; (2) 继承Comparable接口，重写compareTo方法
        System.out.println("=======================");
        class Rec implements Comparable<Rec> {
            int x, y;
            public Rec(int x, int y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public int compareTo(Rec o) { return this.x - o.x; }  // this在前：升序
            @Override
            public String toString() { return "Rec{" + "x=" + x + ", y=" + y + '}'; }
        }
        ArrayList<Rec> r = new ArrayList<>();
        for (int i = 0; i < 4; i++) r.add(new Rec(-i, i));
        // 方式(1)
        Collections.sort(r, (o1, o2) -> o1.x - o2.x);  // o1在前：升序
        System.out.println(r);
        // 方式(2)
        Collections.sort(r);
        System.out.println(r);
    }

    // lower_bound/upper_bound
    @Test
    public void test13() {

        // java 中不存在这两个函数，可以自己实现
        int[] a = {1, 2, 4, 5, 6};
        System.out.println(lower_bound(a, 4));  // 4
        System.out.println(lower_bound(a, 8));  // null
        System.out.println(upper_bound(a, 4));  // 5
        System.out.println(upper_bound(a, 6));  // null
    }

    // 返回 a 中大于等于 x 的最小元素
    public Integer lower_bound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] >= x) r = mid;
            else l = mid + 1;
        }
        if (r == a.length) return null;
        return a[r];
    }

    // 返回 a 中大于 x 的最小元素
    public Integer upper_bound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] > x) r = mid;
            else l = mid + 1;
        }
        if (r == a.length) return null;
        return a[r];
    }


    // nth_element
    @Test
    public void test14() {

        // java 中不存在nth_element，可以自己实现
        int[] a = {6, 2, 1, 4, 3, 5};
        int k = 2;  // a[1]已经被排到正确的位置上(递增序)，第二小的数
        System.out.println(quick_sort(a, 0, a.length - 1, k));  // 2
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }

    // 返回 q[l...r]中第k小的数据
    public int quick_sort(int[] q, int l, int r, int k) {

        if (l == r) return q[l];

        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int t = q[i]; q[i] = q[j]; q[j] = t;
            }
        }

        int sl = j - l + 1;
        if (k <= sl) return quick_sort(q, l, j, k);
        return quick_sort(q, j + 1, r, k - sl);
    }
}
