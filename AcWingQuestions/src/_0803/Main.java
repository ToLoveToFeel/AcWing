package _0803;

import java.util.*;

/**
 * Date: 2020/12/27 11:35
 * Content:
 */
public class Main {

    private static class MyPair implements Comparable<MyPair> {

        public int first;
        public int second;

        public MyPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(MyPair o) {
            return this.first - o.first;
        }
    }

    private static List<MyPair> merge(List<MyPair> segs) {

        List<MyPair> res = new ArrayList<>();

        Collections.sort(segs);

        int st = Integer.MIN_VALUE, ed = Integer.MIN_VALUE;
        for (MyPair seg : segs) {
            if (ed < seg.first) {
                if (st != Integer.MIN_VALUE)  // 当前考察的不是第一个区间
                    res.add(new MyPair(st, ed));
                st = seg.first;
                ed = seg.second;
            } else ed = Math.max(ed, seg.second);
        }
        // 最后一个合并后区间加入到答案中
        if (st != Integer.MIN_VALUE) res.add(new MyPair(st, ed));

        return res;
    }

    public static void main(String[] args) {

        // 读入数据
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 区间个数
        List<MyPair> segs = new ArrayList<>();

        for (int i = 0; i < n; i++) segs.add(new MyPair(scan.nextInt(), scan.nextInt()));

        // 算法代码
        System.out.println(merge(segs).size());
    }
}
