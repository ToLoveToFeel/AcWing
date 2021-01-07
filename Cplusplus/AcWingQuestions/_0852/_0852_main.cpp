#include <cstring>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 20010;

int n, m;  // 总点数，总边数
int h[N], w[N], e[N], ne[N], idx;  // 邻接表存储所有边
int dist[N], cnt[N];  // dist[x]存储1号点到x的最短距离，cnt[x]存储1到x的最短路中经过的点数
bool st[N];  // 存储每个点是否在队列中

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[a] = h[a], h[a] = idx++;
}

// 如果存在负环，则返回true，否则返回false。
bool spfa() {

    // 不需要初始化dist数组
    // 原理：如果某条最短路径上有n个点（除了自己），那么加上自己之后一共有n+1个点，由抽屉原理一定有两个点相同，所以存在环。

    queue<int> q;
    for (int i = 1; i <= n; i++) {
        q.push(i);
        st[i] = true;
    }

    while (q.size()) {
        auto t = q.front();
        q.pop();

        st[t] = false;

        for (int i = h[t]; i != -1; i = ne[i]) {
            int j = e[i];
            if (dist[j] > dist[t] + w[i]) {
                dist[j] = dist[t] + w[i];
                cnt[j] = cnt[t] + 1;
                if (cnt[j] >= n) return true;       // 如果从1号点到x的最短路中包含至少n个点（不包括自己），则说明存在环
                if (!st[j]) {
                    q.push(j);
                    st[j] = true;
                }
            }
        }
    }

    return false;
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

    if(spfa()) puts("Yes");
    else puts("No");

    return 0;
}
