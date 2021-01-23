// Created by WXX on 2021/1/23 22:09
#include <iostream>

using namespace std;

typedef long long LL;
const int N = 10010;

int n, m;
LL f[N];

// 完全背包问题
int main() {

    cin >> n >> m;
    f[0] = 1;
    for (int i = 1; i <= n; i++) {  // 循环物品
        int v;
        cin >> v;
        for (int j = v; j <= m; j++)
            f[j] += f[j - v];
    }
    cout << f[m] << endl;
    return 0;
}
