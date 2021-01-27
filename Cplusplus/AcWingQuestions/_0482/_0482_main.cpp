// Created by WXX on 2021/1/27 22:09
#include <iostream>

using namespace std;

const int N = 110;

int n;
int h[N];
int f[N], g[N];  // 以h[i]结尾的最长上升子序列，以h[i]开始的最长下降子序列

int main() {

    cin >> n;
    for (int i = 1; i <= n; i++) cin >> h[i];
    for (int i = 1; i <= n; i++) {
        f[i] = 1;
        for (int j = 1; j < i; j++)
            if (h[j] < h[i])
                f[i] = max(f[i], f[j] + 1);
    }
    for (int i = n; i >= 1; i--) {
        g[i] = 1;
        for (int j = n; j > i; j--)
            if (h[j] < h[i])
                g[i] = max(g[i], g[j] + 1);
    }

    int res = 0;
    for (int k = 1; k <= n; k++)
        res = max(res, f[k] + g[k] - 1);

    cout << n - res << endl;

    return 0;
}

