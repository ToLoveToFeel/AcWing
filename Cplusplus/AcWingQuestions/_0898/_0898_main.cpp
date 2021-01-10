#include <iostream>

using namespace std;

const int N = 510;

int n;
int w[N][N], f[N][N];  // w存储三角形中的值，w[1][1]代表第一行的值，f用于动态规划

// 动态规划，从下向上动态规划
// f[i][j] 代表从下向上到达w[i][j]的最大值
int main() {

    cin >> n;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= i; j++)
            cin >> w[i][j];

    for (int i = 1; i <= n; i++) f[n][i] = w[n][i];
    for (int i = n - 1; i; i--)
        for (int j = 1; j <= i; j++)
            f[i][j] = max(f[i + 1][j], f[i + 1][j + 1]) + w[i][j];

    cout << f[1][1] << endl;

    return 0;
}