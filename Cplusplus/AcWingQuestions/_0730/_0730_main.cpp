// Created by WXX on 2021/2/16 20:16
#include <iostream>

using namespace std;

const int N = 1e5 + 10;

int n;
int h[N];

bool check(int mid) {

    for (int i = 1; i <= n; i++) {
        mid = mid * 2 - h[i];
        if (mid < 0) return false;
        if (mid >= 1e5) return true;  // 防止数据溢出
    }
    return true;
}

// 考点：二分
int main() {

    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &h[i]);

    int l = 0, r = 1e5;
    while (l < r) {
        int mid = l + r >> 1;
        if (check(mid)) r = mid;
        else l = mid + 1;
    }

    printf("%d\n", r);

    return 0;
}
