// Created by WXX on 2021/2/1 11:06
#include <iostream>

using namespace std;

const int N = 100010, M = N * 21;

int n;
int s[N];  // 异或前缀和
int son[M][2], id[M], idx;  // trie, id存储的是该数字在数组中的下标

void insert(int x, int k) {
    int p = 0;
    for (int i = 20; i >= 0; i--) {
        int u = x >> i & 1;
        if (!son[p][u]) son[p][u] = ++idx;
        p = son[p][u];
    }
    id[p] = k;
}

int query(int x) {
    int p = 0;
    for (int i = 20; i >= 0; i--) {
        int u = x >> i & 1;
        if (son[p][!u]) p = son[p][!u];
        else p = son[p][u];
    }
    return id[p];
}

int main() {

    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &s[i]);
        s[i] ^= s[i - 1];
    }

    int res = -1, a, b;
    insert(s[0], 0);
    for (int i = 1; i <= n; i++) {
        int k = query(s[i]);
        int t = s[i] ^ s[k];
        if (t > res) res = t, a = k + 1, b = i;
        insert(s[i], i);
    }

    printf("%d %d %d\n", res, a, b);

    return 0;
}
