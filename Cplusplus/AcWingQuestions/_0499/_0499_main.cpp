// Created by WXX on 2021/2/6 20:58
#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;
const int N = 200010;

int n, m;
LL S;
int w[N], v[N];
LL sum[N], cnt[N];
int L[N], R[N];

LL get_y(int W) {
    for (int i = 1; i <= n; i++)
        if (w[i] >= W) {
            sum[i] = sum[i - 1] + v[i];
            cnt[i] = cnt[i - 1] + 1;
        } else {
            sum[i] = sum[i - 1];
            cnt[i] = cnt[i - 1];
        }

    LL res = 0;
    for (int i = 0; i < m; i++)
        res += (sum[R[i]] - sum[L[i] - 1]) * (cnt[R[i]] - cnt[L[i] - 1]);
    return res;
}

int main() {

    scanf("%d%d%lld", &n, &m, &S);
    for (int i = 1; i <= n; i++) scanf("%d%d", &w[i], &v[i]);
    for (int i = 0; i < m; i++) scanf("%d%d", &L[i], &R[i]);

    int l = 0, r = 1e6 + 1;
    while (l < r) {
        int mid = l + r + 1 >> 1;
        if (get_y(mid) >= S) l = mid;
        else r = mid - 1;
    }

    printf("%lld\n", min(get_y(r) - S, S - get_y(r + 1)));
    return 0;
}
