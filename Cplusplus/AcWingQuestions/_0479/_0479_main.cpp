// Created by WXX on 2021/1/30 14:39
#include <iostream>

using namespace std;

const int N = 35;

int n;
int w[N], f[N][N], g[N][N];

void dfs(int l, int r) {

    if (l > r) return;
    int k = g[l][r];
    cout << k << ' ';
    dfs(l, k - 1), dfs(k + 1, r);
}

int main() {

    cin >> n;
    for (int i = 1; i <= n; i++) cin >> w[i];

    for (int len = 1; len <= n; len++)
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            if (len == 1) f[i][j] = w[i], g[i][j] = i;
            else {
                for (int k = i; k <= j; k++) {
                    int left = (k == i ? 1 : f[i][k - 1]);
                    int right = (k == j ? 1 : f[k + 1][j]);
                    int score = w[k] + left * right;
                    if (score > f[i][j]) {
                        f[i][j] = score;
                        g[i][j] = k;
                    }
                }
            }
        }

    cout << f[1][n] << endl;
    dfs(1, n);

    return 0;
}
