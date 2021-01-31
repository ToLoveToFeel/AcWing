// Created by WXX on 2021/1/31 23:59
#include <iostream>

using namespace std;

const int N = 110;

int n;
int s[N][N];  // 列方向上的前缀和，s[i][j]:表示第j列前i个数据之和

int main() {

    cin >> n;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++) {
            int x;
            cin >> x;
            s[i][j] = s[i - 1][j] + x;
        }

    int res = -200;
    for (int i = 1; i <= n; i++)
        for (int j = i; j <= n; j++) {
            int f = 0;
            for (int k = 1; k <= n; k++) {
                int w = s[j][k] - s[i - 1][k];
                f = max(f, 0) + w;
                res = max(res, f);
            }
        }

    cout << res << endl;

    return 0;
}
