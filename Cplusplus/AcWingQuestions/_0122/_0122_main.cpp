// Created by WXX on 2021/2/4 13:32
#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;
const int N = 1000010;

int n;
LL s[N], c[N];

int main() {

    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%lld", &s[i]);
        s[i] += s[i - 1];
    }

    LL b = s[n] / n;
    int k = 0;
    for (int i = 1; i < n; i++) c[k++] = i * b - s[i];
    c[k++] = 0;

    nth_element(c, c + k / 2, c + k);
    LL res = 0;
    for (int i = 0; i < k; i++)
        res += abs(c[i] - c[k / 2]);

    printf("%lld\n", res);

    return 0;
}
