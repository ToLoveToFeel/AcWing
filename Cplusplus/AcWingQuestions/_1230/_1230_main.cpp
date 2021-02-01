// Created by WXX on 2021/2/1 22:33
#include <iostream>

using namespace std;

typedef long long LL;
const int N = 100010;

int n, k;
LL s[N];
int cnt[N];

int main() {

    scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &s[i]);
        s[i] += s[i - 1];
    }

    LL res = 0;
    cnt[0]++;
    for (int i = 1; i <= n; i++) {
        res += cnt[s[i] % k];
        cnt[s[i] % k]++;
    }

    printf("%lld\n", res);

    return 0;
}
