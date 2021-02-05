// Created by WXX on 2021/2/5 14:28
#include <iostream>

using namespace std;

typedef long long LL;

// a ^ b mod p
int qmi(int a, int b, int p) {

    int res = 1 % p;
    while (b) {
        if (b & 1) res = (LL) res * a % p;
        a = (LL) a * a % p;
        b >>= 1;
    }
    return res;
}

int main() {

    int a, b, p;
    cin >> a >> b >> p;
    cout << qmi(a, b, p) << endl;
    return 0;
}
