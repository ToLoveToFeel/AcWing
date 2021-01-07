#include <cstring>
#include <iostream>

using namespace std;

const int N = 100010, M = 200010;

int n, m;
int h[N], e[M], ne[M], idx;  // 邻接表存储图
int color[N];  // 表示每个点的颜色，-1表示未染色，0表示白色，1表示黑色

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool dfs(int u, int c) {
    color[u] = c;

    for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (color[j] == -1) {
            if (!dfs(j, !c)) return false;
        } else if (color[j] == c) return false;
    }
    return true;
}

int main() {

    scanf("%d%d", &n, &m);

    memset(h, -1, sizeof h);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b), add(b, a);
    }

    memset(color, -1, sizeof h);
    bool flag = true;  // 记录是否是二分图
    for (int i = 1; i <= n; i++)
        if (color[i] == -1) {
            if (!dfs(i, 0)) {
                flag = false;
                break;
            }
        }

    if (flag) puts("Yes");
    else puts("No");

    return 0;
}