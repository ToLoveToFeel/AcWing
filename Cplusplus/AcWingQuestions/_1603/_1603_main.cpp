// Created by WXX on 2021/1/27 21:39
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 100010;

int n;
int w[N];

int main() {

    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &w[i]);
    sort(w, w + n);
    int s1 = 0, s2 = 0;
    for (int i = 0; i < n / 2; i++) s1 += w[i];
    for (int i = n / 2; i < n; i++) s2 += w[i];
    printf("%d %d\n", n % 2, s2 - s1);

    return 0;
}
