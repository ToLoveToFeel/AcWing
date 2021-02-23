// Created by WXX on 2021/2/23 10:25
#include <iostream>

using namespace std;

const int N = 1010;

int n;
int q[N];

int main() {

    cin >> n;
    for (int i = 0; i < n; i++) cin >> q[i];

    int res = 0;
    for (int i = 1; i < n - 1; i++) {
        int a = q[i - 1], b = q[i], c = q[i + 1];
        if ((b > a && b > c) || (b < a && b < c))
            res++;
    }
    cout << res << endl;

    return 0;
}
