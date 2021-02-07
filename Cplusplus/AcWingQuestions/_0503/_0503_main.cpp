// Created by WXX on 2021/2/7 23:11
#include <iostream>

using namespace std;

typedef long long LL;
const int N = 1000010;

int n, m;
int r[N], d[N], s[N], t[N];
LL b[N];  // 差分数组

bool check(int mid) {
    for (int i = 1; i <= n; i++) b[i] = r[i] - r[i - 1];
    for (int i = 1; i <= mid; i++) {
        b[s[i]] -= d[i];
        b[t[i] + 1] += d[i];
    }
    for (int i = 1; i <= n; i++) {
        b[i] += b[i - 1];
        if (b[i] < 0) return true;
    }
    return false;
}

int main() {

    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) scanf("%d", &r[i]);
    for (int i = 1; i <= m; i++) scanf("%d%d%d", &d[i], &s[i], &t[i]);

    if (!check(m)) {
        puts("0");
        return 0;
    }

    int l = 1, r = r = m;
    while (l < r) {
        int mid = l + r >> 1;
        if (check(mid)) r = mid;
        else l = mid + 1;
    }

    printf("-1\n%d\n", r);

    return 0;
}
