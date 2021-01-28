// Created by WXX on 2021/1/28 16:55
#include <iostream>

using namespace std;

const int N = 1e5 + 10;
int son[N][26];  // 存储Trie树
int cnt[N];  // cnt[idx]：idx代表的单词的数目
int idx;  // 指针
char str[N];

void insert(char *str) {
    int p = 0;
    for (int i = 0; str[i]; i++) {
        int u = str[i] - 'a';
        if (!son[p][u]) son[p][u] = ++idx;
        p = son[p][u];
    }
    cnt[p]++;
}

int query(char *str) {
    int p = 0;
    for (int i = 0; str[i]; i++) {
        int u = str[i] - 'a';
        if (!son[p][u]) return 0;
        p = son[p][u];
    }
    return cnt[p];
}

int main() {

    int n;
    scanf("%d", &n);
    char op[2];
    while (n--) {
        scanf("%s%s", op, str);
        if (op[0] == 'I') insert(str);
        else printf("%d\n", query(str));
    }

    return 0;
}
