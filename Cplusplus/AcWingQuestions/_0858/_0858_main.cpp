#include <cstring>
#include <iostream>

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;

int n, m;  // 点数，边数
int g[N][N];  // 邻接矩阵
int dist[N];  // dist[j] 表示从已经求得mst的集合中到达j点的最短的一条
bool st[N];  // 已在mst集合中的点

int prim() {
    memset(dist, 0x3f, sizeof dist);

    int res = 0;  // 记录整个图的MST最小权值和
    for (int i = 0; i < n; ++i) {
        // 寻找当前与mst集合连接的最小的边对应的顶点t
        int t = -1;
        for (int j = 1; j <= n; j++)
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;

        if (i && dist[t] == INF) return INF;  // 如果图不连通的话，不存在MST
        if (i) res += dist[t];  // 这句话要放在更新的前面，否则，存在负权自环会更新dist[t]
        st[t] = true;  // 点t放入mst中

        for (int j = 1; j <= n; j++) dist[j] = min(dist[j], g[t][j]);
    }

    return res;
}

int main() {

    scanf("%d%d", &n, &m);

    memset(g, 0x3f, sizeof g);

    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        g[a][b] = g[b][a] = min(g[a][b], c);
    }

    int t = prim();

    if (t == INF) puts("impossible");
    else printf("%d\n", t);

    return 0;
}