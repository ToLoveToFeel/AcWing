// Created by WXX on 2021/2/23 11:02
#include <iostream>
#include <cstring>

using namespace std;

const int N = 20010, M = 20010;

int n, m;
int h[N], e[M], ne[M], idx;
int ans;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

// 考点：树的直径
// 思路：求出从根节点u出发得到的最长路径长度和次大长度，相加即为结果
// 该函数返回从根节点u出发得到的最长路径长度
int dfs(int u) {

    int d1 = 0, d2 = 0;
    for (int i = h[u]; ~i; i = ne[i]) {
        int j = e[i];
        int d = dfs(j);
        if (d >= d1) d2 = d1, d1 = d;
        else if (d > d2) d2 = d;
    }
    ans = max(ans, d1 + d2);
    return d1 + 1;  // +1 是为了加上从u出发的那一条边
}

int main() {

    cin >> n >> m;
    memset(h, -1, sizeof h);
    for (int i = 2; i <= n; i++) {
        int p;
        cin >> p;
        add(p, i);  // 添加一条父节点指向子节点的边
    }
    for (int i = 1; i <= m; i++) {
        int p;
        cin >> p;
        add(p, n + i);  // 编号为 i 的电脑映射到网络中的编号为 n+i，防止编号重复
    }
    dfs(1);
    cout << ans << endl;

    return 0;
}
