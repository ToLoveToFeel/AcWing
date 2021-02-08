// Created by WXX on 2021/2/8 20:53
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

// a表示首项，d表示公差，l表示到达鱼塘的时间前缀和，spend表示在每个鱼塘度过的时间
int a[N], d[N], l[N], spend[N];

int get(int k) {
    return max(0, a[k] - d[k] * spend[k]);
}

int work(int n, int T) {

    int res = 0;
    memset(spend, 0, sizeof spend);
    for (int i = 0; i < T; i++) {
        int t = 1;
        for (int j = 1; j <= n; j++)  // 选择多路归并中的最大值
            if (get(j) > get(t))
                t = j;
        res += get(t);
        spend[t]++;
    }
    return res;
}

int main() {

    int n, T;
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++) cin >> d[i];
    for (int i = 2; i <= n; i++) {
        cin >> l[i];
        l[i] += l[i - 1];
    }
    cin >> T;

    int res = 0;
    for (int i = 1; i <= n; i++)
        res = max(res, work(i, T - l[i]));

    cout << res << endl;

    return 0;
}
