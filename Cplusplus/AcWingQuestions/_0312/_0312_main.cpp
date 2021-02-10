// Created by WXX on 2021/2/10 22:53
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 41, M = 360;

int n, m;
int w[M], b[4];  // b中存储每种卡片数量
int f[N][N][N][N];

int main() {

    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> w[i];
    while (m--) {
        int x;
        cin >> x;
        b[x - 1]++;
    }

    for (int A = 0; A <= b[0]; A++)
        for (int B = 0; B <= b[1]; B++)
            for (int C = 0; C <= b[2]; C++)
                for (int D = 0; D <= b[3]; D++) {
                    int score = w[A * 1 + B * 2 + C * 3 + D * 4];
                    int &v = f[A][B][C][D];
                    v = score;
                    if (A) v = max(v, f[A - 1][B][C][D] + score);
                    if (B) v = max(v, f[A][B - 1][C][D] + score);
                    if (C) v = max(v, f[A][B][C - 1][D] + score);
                    if (D) v = max(v, f[A][B][C][D - 1] + score);
                }

    cout << f[b[0]][b[1]][b[2]][b[3]] << endl;
    return 0;
}

