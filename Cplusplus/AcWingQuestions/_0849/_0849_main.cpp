#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 510;

int n, m;  // 顶点数，边数
int g[N][N];  // 稠密图，使用邻接矩阵存储
int dist[N];  // 存储起始点(1号点)到其他点的最短距离
bool st[N];  // 标记当前点是否已经求出最短距离，默认都是false

int dijkstra() {

    memset(dist, 0x3f, sizeof(dist));
    dist[1] = 0;  // 起始点到起始点距离为0

    for (int i = 0; i < n; ++i) {  // n次循环，每次得到一个解
        int t = -1;  // 记录不在s(已经求出最短距离的点的集合)距离最近的点
        for (int j = 1; j <= n; j++)
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;

        st[t] = true;  // 得到一个解

        for (int j = 1; j <= n; j++)  // 用t更新其他点的距离
            dist[j] = min(dist[j], dist[t] + g[t][j]);
    }

    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}

int main() {
    // 读入点数，边数
    scanf("%d%d", &n, &m);
    // 设置所有点之间距离都是无穷
    memset(g, 0x3f, sizeof(g));
    // 读入所有的边
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        g[a][b] = min(g[a][b], c);  // 解决自环和重边的问题，只保留一条权值最小的
    }

    int t = dijkstra();

    printf("%d\n", t);

    return 0;
}
