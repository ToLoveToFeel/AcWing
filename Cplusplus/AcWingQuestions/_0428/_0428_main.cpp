// Created by WXX on 2021/2/7 22:12
#include <iostream>

using namespace std;

int power(int a, int b) {
    int res = 1;
    while (b--) res *= a;
    return res;
}

int main() {

    int k, n;
    cin >> k >> n;
    int res= 0;
    for (int i = 0; i < 10; i++)
        if (n >> i & 1)
            res += power(k, i);
    cout << res << endl;

    return 0;
}
