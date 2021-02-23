// Created by WXX on 2021/2/23 10:33
#include <iostream>

using namespace std;

int main() {

    int res = 0, score = 0, x;  // score表示跳到该格子上得分
    while (cin >> x, x)
        if (x == 1) res++, score = 0;
        else score += 2, res += score;
    cout << res << endl;

    return 0;
}
