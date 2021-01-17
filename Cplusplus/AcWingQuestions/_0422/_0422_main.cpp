#include <iostream>

using namespace std;

const int N = 10010;

int n, m;
bool st[N];

// 暴力解法
int main() {

    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int l, r;
        cin >> l >> r;
        for (int j = l; j <= r; j++) st[j] = true;
    }

    int res = 0;
    for (int i = 0; i <= n; i++)
        if (st[i] == false)
            res++;

    cout << res << endl;
}