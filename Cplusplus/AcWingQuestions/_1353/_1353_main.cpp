// Created by WXX on 2021/1/26 19:11
#include <iostream>

using namespace std;

const int N = 1010;

int n;
int h[N];

int main() {

    cin >> n;
    for (int i = 0; i < n; i++) cin >> h[i];

    int res = 1e8;
    for (int i = 0; i + 17 <= 100; i++) {
        int cost = 0, l = i, r = l + 17;
        for (int j = 0; j < n; j++)
            if (h[j] < l) cost += (l - h[j]) * (l - h[j]);
            else if (h[j] > r) cost += (h[j] - r) * (h[j] - r);
        res = min(cost, res);
    }

    cout << res << endl;

    return 0;
}
