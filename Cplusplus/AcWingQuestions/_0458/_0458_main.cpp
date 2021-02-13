// Created by WXX on 2021/2/13 10:00
#include <iostream>

using namespace std;

int main() {

    int A, B, L;
    cin >> A >> B >> L;

    int a, b;
    double delta = 1e9;
    for (int i = 0; i <= L; i++) {
        for (int j = 1; j <= L; j++) {
            double x = (double) i / j;
            double X = (double) A / B;
            if (x >= X && x - X < delta) {
                delta = x - X;
                a = i, b = j;
            }
        }
    }

    cout << a << ' ' << b << endl;

    return 0;
}
