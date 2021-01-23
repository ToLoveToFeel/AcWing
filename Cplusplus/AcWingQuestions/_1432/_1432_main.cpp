// Created by WXX on 2021/1/23 20:07
#include <iostream>

using namespace std;

const int N = 15;

int n;
int col[N], dg[N * 2], udg[N * 2];
int path[N], ans;

void dfs(int x) {
    if (x > n) {
        ans++;
        if (ans <= 3) {
            for (int i = 1; i <= n; i++)
                cout << path[i] << ' ';
            cout << endl;
        }
        return;
    }

    for (int y = 1; y <= n; y++) {
        if (!col[y] && !dg[x + y] && !udg[x - y + n]) {
            path[x] = y;
            col[y] = dg[x + y] = udg[x - y + n] = true;
            dfs(x + 1);
            col[y] = dg[x + y] = udg[x - y + n] = false;
            path[x] = 0;
        }
    }
}

int main() {

    cin >> n;
    dfs(1);
    cout << ans << endl;

    return 0;
}
