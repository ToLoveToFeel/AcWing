#include <cstring>
#include <iostream>
#include <queue>

using namespace std;

// SPFA     一般是O(m), 最坏O(n*m)     Bellman-Ford的优化

const int N = 100010;

int n, m;  // 顶点数，边数
int h[N], e[N], w[N], ne[N], idx;  // 稀疏图，使用邻接表存储
int dist[N];  // 存储起始点(1号点)到其他点的最短距离
bool st[N];  // 标记当前点是否已经求出最短距离，默认都是false

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

int spfa() {

    memset(dist, 0x3f, sizeof(dist));
    dist[1] = 0;

    queue<int> q;
    q.push(1);
    st[1] = true;  // 代表在队列中

    while (q.size()) {
        int t = q.front();
        q.pop();

        st[t] = false;

        for (int i = h[t]; i != -1; i = ne[i]) {
            int j = e[i];
            if (dist[j] > dist[t] + w[i]) {
                dist[j] = dist[t] + w[i];
                if (!st[j]) {
                    q.push(j);
                    st[j] = true;
                }
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

    int t = spfa();

    if (t == -1) puts("impossible");
    else printf("%d\n", t);

    return 0;
}
