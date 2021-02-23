// Created by WXX on 2021/2/23 10:18
#include <iostream>
#include <vector>

using namespace std;

const int N = 1010;

int n;
int q[N];

int main() {

    cin >> n;
    for (int i = 0; i < n; i++) cin >> q[i];
    int res = 0;
    for (int i = 1; i < n; i++)
        res = max(res, abs(q[i] - q[i - 1]));
    cout << res << endl;

    return 0;
}
