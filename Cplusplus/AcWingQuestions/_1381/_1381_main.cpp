// Created by WXX on 2021/1/24 23:03
#include <iostream>

using namespace std;

// 时间复杂度：O(n*log(n))
int main() {

    int n;
    cin >> n;
    int res = 1, d2 = 0, d5 = 0;
    for (int i = 1; i <= n; i++) {
        int x = i;
        while (x % 2 == 0) x /= 2, d2++;
        while (x % 5 == 0) x /= 5, d5++;
        res = res * x % 10;
    }

    int k = min(d2, d5);  // d2一定大于d5
    for (int i = 0; i < d2 - k; i++) res = res * 2 % 10;
    for (int i = 0; i < d5 - k; i++) res = res * 5 % 10;
    cout << res << endl;

    return 0;
}
