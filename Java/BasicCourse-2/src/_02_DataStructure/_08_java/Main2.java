package _02_DataStructure._08_java;

import javafx.util.Pair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
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
        // 随机返回HashSet中的一个数据
        System.out.println(hash.iterator().next());
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
        for (int v : a.values()) System.out.print(v + "\t");  // 只遍历值
        System.out.println();
        // 随机返回HashMap中的一个键
        System.out.println(a.keySet().iterator().next());
        // 随机返回HashMap中的一个值
        System.out.println(a.values().iterator().next());
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
        for (int v : hash.values()) System.out.print(v + "\t");  // 只遍历值
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
        System.out.println(Arrays.toString(a));  // [1, 2, 3, 4, 5]
        Integer[] arr = new Integer[a.length];  // 对数组自定义比较运算需要先转为包装类
        for (int i = 0; i < a.length; i++) arr[i] = a[i];
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr));  // [5, 4, 3, 2, 1]

        // 对 ArrayList 排序
        System.out.println("=======================");
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(3, 1, 4, 5, 2));
        Collections.sort(t);
        System.out.println(t);  // [1, 2, 3, 4, 5]

        // 对String进行排序
        String s = "dcab43210";
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        String res = new String(cs);
        System.out.println(res);  // 01234abcd

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
        System.out.println(r);  // [Rec{x=-3, y=3}, Rec{x=-2, y=2}, Rec{x=-1, y=1}, Rec{x=0, y=0}]
        // 方式(2)
        Collections.sort(r);
        System.out.println(r);  // [Rec{x=-3, y=3}, Rec{x=-2, y=2}, Rec{x=-1, y=1}, Rec{x=0, y=0}]
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

    @Test
    public void test15() {
        // 设置随机种子的话可以保证每次运行程序生成的序列时一致的
        // 不同于C++, 如果不设置随机种子，每次运行得到的序列时不同的
        Random r = new Random();
        System.out.println(r.nextInt());
        System.out.println(r.nextInt());

        // 生成[0, x)范围的随机数据
        int x = 15;
        System.out.println(r.nextInt(x));

        System.out.println("-------------------------------------");
        int a = 5, b = 6;
        // 生成[a, b)范围的随机数据
        System.out.println(r.nextInt(b - a) + a);
        // 生成(a, b]范围的随机数据
        System.out.println(r.nextInt(b - a) + a + 1);
        // 生成[a, b]范围的随机数据
        System.out.println(r.nextInt(b - a + 1) + a);
        System.out.println("-------------------------------------");
        // 生成[a, b)范围的随机数据
        System.out.println((int) (Math.random() * (b - a) + a));
        // 生成(a, b]范围的随机数据
        System.out.println((int) (Math.random() * (b - a) + a + 1));
        // 生成[a, b]范围的随机数据
        System.out.println((int) (Math.random() * (b - a + 1) + a));

        System.out.println("-------------------------------------");
        // 生成[0.0, 1,0)范围的随机数据
        System.out.println(Math.random());
    }

    // String
    @Test
    @SuppressWarnings("all")
    public void test16() throws Exception {

        String s1 = "HelloWorld";
        // 输出字符串长度
        System.out.println(s1.length());  // 10
        // 获取字符串中某个字符
        System.out.println(s1.charAt(0));  // H
        // 判断字符串是否为空
        System.out.println(s1.isEmpty());  // False
        // 将字符串转化为全小写/全大写 后返回
        System.out.println(s1.toLowerCase());  // helloworld
        System.out.println(s1.toUpperCase());  // HELLOWORLD
        System.out.println(s1);  // HelloWorld
        // 去除字符串前后的空格
        System.out.println("--" + "  he llo  world   ".trim() + "--");  // --he llo  world--
        // 比较字符串
        String s2 = "helloWorld";
        System.out.println(s1.equals(s2));  // false  直接比较字符串内容
        System.out.println(s1.equalsIgnoreCase(s2));  // true  忽略大小写比较字符串内容
        // 字符串连接
        System.out.println(s1.concat("You"));  // HelloWorldYou  等价于+
        // 比较字符串的大小
        System.out.println("abc".compareTo("abcd"));  // -1  负数意味着左边小，正数左边大，0相等
        // 截取字符串 substring(int beginIndex, int endIndex) 左闭右开
        String s3 = "我爱你中国";
        System.out.println(s3.substring(3));  // 中国
        System.out.println(s3.substring(0, 3));  // 我爱你


        System.out.println("-------------------------------------");
        System.out.println(s1);  // HelloWorld
        // 测试此字符串是否以指定的后缀结束
        System.out.println(s1.endsWith("world"));  // false
        // 测试此字符串是否以指定的前缀开始
        System.out.println(s1.startsWith("He"));  // true
        // 测试此字符串从指定索引开始的子字符串是否以指定前缀开始
        System.out.println(s1.startsWith("ll", 2));  // true


        System.out.println("-------------------------------------");
        System.out.println(s1);  // HelloWorld
        // 测试当前字符串是否包含指定的char值序列
        System.out.println(s1.contains("ll"));  // true

        // 返回指定子字符串在此字符串中第一次出现处的索引，没有返回-1
        System.out.println(s1.indexOf("ll"));  // 2
        // 返回指定子字符串在此字符串中第一次出现处的索引，从指定索引开始
        System.out.println(s1.indexOf("ll", 5));  // -1

        // 返回指定子字符串在此字符串最右边出现的索引
        System.out.println(s1.lastIndexOf("o"));  // 6
        // 返回指定子字符串在此字符串最右边出现的索引，从指定索引开始反向搜索
        System.out.println(s1.lastIndexOf("o", 5));  // 4


        System.out.println("-------------------------------------");
        String s4 = "北京欢迎您! 北京欢迎您!";
        // String replace(char a, char b)
        // 返回一个新的字符串，它是通过b替此字符串中出现的所有a得到的
        System.out.println(s4.replace('北', '南'));  // 南京欢迎您! 南京欢迎您!
        // String replace(CharSequence a, CharSequence b)
        // 返回一个新的字符串，它是通过b替此字符串中出现的所有a得到的
        System.out.println(s4.replace("北京", "上海"));  // 上海欢迎您! 上海欢迎您!

        // String replaceAll(String regex, String b)
        // 返回一个字符串，它是通过b替换此字符串所有匹配的正则表达式得到的
        String s5 = "12hello34world5java7891mysql456";
        // hello,world,java,mysql
        System.out.println(s5.replaceAll("\\d+", ",").replaceAll("^,|,$", ""));
        // String replaceFirst(String regex, String b)
        // 返回一个字符串，它是通过b替换此字符串第一个匹配的正则表达式得到的
        // hello,world,java,mysql,
        System.out.println(s5.replaceAll("\\d+", ",").replaceFirst("^,|,$", ""));

        // boolean matches(String regrex)
        // 告知此字符串是否匹配给定的正则表达式
        System.out.println("12345".matches("\\d+"));  // true
        System.out.println("0571-4534289".matches("0571-\\d{7,8}"));  // true

        // String[] split(String regrex)
        // 根据给定正则表达式拆分此字符串
        String s6 = "  good    good study, day day up   ";
        // 去掉前后空格后用空格将字符串分开, \\s+ 会将多个空格看做一个
        String[] strs1 = s6.trim().split("\\s+");
        System.out.println(strs1.length);  // 6
        // String[] split(String regrex, int limit)
        // 根据给定正则表达式拆分此字符串, 最多不超过limit个, 如果超过了, 剩下的放到最后一个元素中
        String[] strs2 = s6.trim().split("\\s+", 3);
        System.out.println(strs2.length);  // 3


        System.out.println("-------------------------------------");
        System.out.println(Integer.parseInt("123"));  // String -> 基本数据类型/包装类
        System.out.println(Double.parseDouble("1.2e9"));  // String -> 基本数据类型/包装类
        System.out.println(String.valueOf(123));  // 基本数据类型/包装类 -> String
        System.out.println(123.1 + "");  // 基本数据类型/包装类 -> String
        // String -> char[]
        String s7 = "123abc";
        char[] chs = s7.toCharArray();
        System.out.println(Arrays.toString(chs));  // [1, 2, 3, a, b, c]
        // char[] -> String
        System.out.println(new String(chs));  // 123abc
        // String -> byte[]
        byte[] bs1 = s7.getBytes();  // 使用默认的字符集进行转化
        System.out.println(Arrays.toString(bs1));  // [49, 50, 51, 97, 98, 99]
        String s8 = "123abc中国";
        byte[] bs2 = s8.getBytes("gbk");  // 使用gbk进行编码
        System.out.println(Arrays.toString(bs2));  // [49, 50, 51, 97, 98, 99, -42, -48, -71, -6]
        // byte[] -> String
        System.out.println(new String(bs1));  // 123abc
        System.out.println(new String(bs2, "gbk"));  // 123abc中国
    }

    // StringBuilder/StringBuffer
    @Test
    @SuppressWarnings("all")
    public void test17() {

        // StringBuilder/StringBuffer和String相同的方法这里不演示了

        StringBuilder sb = new StringBuilder("abc");

        sb.append(1);
        sb.append('2');
        sb.append("345");
        System.out.println(sb);  // abc12345

        sb.delete(2, 4);
        System.out.println(sb);  // ab2345

        sb.replace(2, sb.length(), "hello");
        System.out.println(sb);  // abhello

        sb.insert(2, false);
        System.out.println(sb);  // abfalsehello

        sb.reverse();
        System.out.println(sb);  // olleheslafba

        String s = sb.substring(1, 3);
        System.out.println(s);  // ll
        System.out.println(sb);  // olleheslafba

        sb.setCharAt(0, 'a');
        System.out.println(sb);  // alleheslafba

        /**
         * 总结：
         * (1) 增：append(xxx)
         * (2) 删: delete(int start, int end)
         * (3) 改: setCharAt(int index, char ch) / replace
         * (4) 查: charAt(int index)
         * (5) 长度: length()
         * (6) 遍历: for (char c : sb.toString().toCharArray()) ...
         */
    }
}
