// Created by WXX on 2021/2/16 19:50
#include <iostream>

using namespace std;

const int N = 100010;

int n;
int h[N];

// 考点：差分、贪心
int main() {

    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &h[i]);

    int res = 0;
    for (int i = n; i; i--) res += max(0, h[i] - h[i - 1]);

    cout << res << endl;

    return 0;
}
