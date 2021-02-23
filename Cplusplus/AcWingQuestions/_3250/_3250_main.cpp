// Created by WXX on 2021/2/23 11:24
#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010, M = 20010;  // 因为要建立反向边，因此边数要x2

int n, m;
// 不能用邻接矩阵，因为邻接矩阵时间复杂度为O(n * n^2) --> 10^9 超时
// 邻接表时间复杂度O(n * m)
int h1[N], h2[N], e[M], ne[M], idx;
bool st1[N], st2[N];  // st1记录从某点出发能到达的点，st2记录能到达该点的点

void add(int h[], int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

// 考点：枚举，dfs
void dfs(int u, int h[], bool st[]) {

    st[u] = true;
    for (int i = h[u]; ~i; i = ne[i]) {
        int j = e[i];
        if (!st[j]) dfs(j, h, st);
    }
}

int main() {

    cin >> n >> m;
    memset(h1, -1, sizeof h1);
    memset(h2, -1, sizeof h2);
    while (m--) {
        int a, b;
        cin >> a >> b;
        add(h1, a, b), add(h2, b, a);
    }

    int res = 0;
    for (int i = 1; i <= n; i++) {
        memset(st1, 0, sizeof st1);
        memset(st2, 0, sizeof st2);
        dfs(i, h1, st1);
        dfs(i, h2, st2);
        int s = 0;
        for (int j = 1; j <= n; j++)
            if (st1[j] || st2[j])
                s++;
        if (s == n) res++;
    }
    cout << res << endl;

    return 0;
}
