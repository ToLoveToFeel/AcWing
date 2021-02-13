// Created by WXX on 2021/2/13 10:36
#include <iostream>

using namespace std;

int main() {

    int l, r;
    cin >> l >> r;

    int res = 0;
    for (int i = l; i <= r; i++)
        for (int j = i; j; j /= 10)
            res += (j % 10 == 2);

    cout << res << endl;

    return 0;
}
