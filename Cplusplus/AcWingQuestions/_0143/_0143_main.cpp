// Created by WXX on 2021/2/1 11:51
#include <iostream>

using namespace std;

const int N = 100010, M = 3100010;

int n;
int a[N];
int son[M][2], idx;

void insert(int x) {
    int p = 0;
    for (int i = 30; i >= 0; i--) {
        int u = x >> i & 1;
        if (!son[p][u]) son[p][u] = ++idx;
        p = son[p][u];
    }
}

int query(int x) {
    int p = 0, res = 0;
    for (int i = 30; i >= 0; i--) {
        int u = x >> i & 1;
        if (son[p][!u]) {
            res += 1 << i;
            p = son[p][!u];
        } else p = son[p][u];
    }
    return res;
}

int main() {

    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        insert(a[i]);
    }

    int res = 0;
    for (int i = 1; i <= n; i++) res = max(res, query(a[i]));

    printf("%d\n", res);

    return 0;
}
