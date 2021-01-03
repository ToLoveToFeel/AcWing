#include <cstring>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

// 堆优化版的Dijkstra算法     O(m*log(n))           适合于稀疏图

typedef pair<int, int> PII;  // (距离，点的编号)
const int N = 150010;

int n, m;  // 顶点数，边数
int h[N], e[N], w[N], ne[N], idx;  // 稀疏图，使用邻接表存储
int dist[N];  // 存储起始点(1号点)到其他点的最短距离
bool st[N];  // 标记当前点是否已经求出最短距离，默认都是false

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

int dijkstra() {

    memset(dist, 0x3f, sizeof(dist));
    dist[1] = 0;  // 起始点到起始点距离为0

    priority_queue<PII, vector<PII>, greater<PII>> heap;
    heap.push({0, 1});

    while (heap.size()) {
        // 寻找当前距离最小的点
        auto t = heap.top();
        heap.pop();

        // 得到一个解
        int ver = t.second, distance = t.first;
        if (st[ver]) continue;  // 如果当前点已经求出最短距离了，就不需要继续求解了
        st[ver] = true;

        // 用当前得到的解更新其他点的距离
        for (int i = h[ver]; i != -1; i = ne[i]) {
            int j = e[i];  // 当前考察的是(i,j)这条边
            if (dist[j] > distance + w[i]) {
                dist[j] = distance + w[i];
                heap.push({dist[j], j});
            }
        }
    }

    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}

int main() {
    // 读入点数，边数
    scanf("%d%d", &n, &m);
    // 设置所有点之间距离都是无穷
    memset(h, -1, sizeof(h));
    // 读入所有的边
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c);  // 邻接表可以自动解决自环和重边的问题，不需要特殊处理
    }

    int t = dijkstra();

    printf("%d\n", t);

    return 0;
}
