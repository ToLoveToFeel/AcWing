// Created by WXX on 2021/1/28 21:46
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
        next_permutation(w + 1, w + n + 1);
    }
    for (int i = 1; i <= n; i++) cout << w[i] << ' ';
    cout << endl;

    return 0;
}
