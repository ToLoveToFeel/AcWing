// Created by WXX on 2021/2/9 21:55
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 110;

int n;
int q[N];

int main() {

    cin >> n;
    for (int i = 0; i < n; i++) cin >> q[i];
    sort(q, q + n);
    int k = unique(q, q + n) - q;
    cout << k << endl;
    for (int i = 0; i < k; i++) cout << q[i] << ' ';
    return 0;
}
