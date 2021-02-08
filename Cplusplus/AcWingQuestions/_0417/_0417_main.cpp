// Created by WXX on 2021/2/8 20:36
#include <iostream>

using namespace std;

int main() {

    int max_time = 0, day;
    for (int i = 1; i <= 7; i++) {
        int a, b;
        cin >> a >> b;
        if (a + b > max_time) max_time = a + b, day = i;
    }

    if (max_time <= 8) cout << 0 << endl;
    else cout << day << endl;

    return 0;
}
