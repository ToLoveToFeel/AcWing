// Created by WXX on 2021/1/28 21:57
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 10010;

int n, m;
int w[N];

int main() {

    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> w[i];
    while (m--) {
        int k = n;
        while (w[k - 1] > w[k]) k--;
        int t = k;
        while (w[t + 1] > w[k - 1]) t++;
        swap(w[k - 1], w[t]);
        reverse(w + k, w + n + 1);
    }
    for (int i = 1; i <= n; i++) cout << w[i] << ' ';
    cout << endl;

    return 0;
}
