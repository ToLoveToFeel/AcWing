// Created by WXX on 2021/2/13 10:16
#include <iostream>

using namespace std;

const int N = 1010, MOD = 10007;

int C[N][N];

int power(int a, int b) {
    a %= MOD;
    int res = 1;
    while (b--) res = res * a % MOD;
    return res;
}

// 组合数：C(n, j) = C(n - 1, j - 1) + C(n - 1, j)
int main() {

    int a, b, k, n, m;
    cin >> a >> b >> k >> n >> m;

    for (int i = 0; i <= k; i++)
        for (int j = 0; j <= i; j++)
            if (!j) C[i][j] = 1;
            else C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;

    cout << C[k][n] * power(a, n) % MOD * power(b, m) % MOD << endl;

    return 0;
}
