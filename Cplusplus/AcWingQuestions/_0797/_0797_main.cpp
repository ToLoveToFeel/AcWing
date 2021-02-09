// Created by WXX on 2021/2/9 22:16
#include <iostream>

using namespace std;

const int N = 100010;

int n, m;  // 数组长度，查询个数
int a[N], b[N];

int main() {

    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);

    // 差分数组初始化
    for (int i = 1; i <= n; i++) b[i] = a[i] - a[i - 1];

    while (m--) {
        int l, r, c;
        scanf("%d%d%d", &l, &r, &c);
        b[l] += c, b[r + 1] -= c;
    }

    for (int i = 1; i <= n; i++) b[i] += b[i - 1];

    // 输出结果
    for (int i = 1; i <= n; i++) printf("%d ", b[i]);

    return 0;
}
