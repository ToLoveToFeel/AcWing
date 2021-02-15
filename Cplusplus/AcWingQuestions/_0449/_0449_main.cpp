// Created by WXX on 2021/2/15 17:44
#include <iostream>

using namespace std;

int main() {

    int n;
    cin >> n;
    for (int p = 2;; p++)
        if (n % p == 0) {
            cout << n / p << endl;
            break;
        }

    return 0;
}
