#include <iostream>

using namespace std;

const int N = 110;

int n;

// 一行一行扩展
int main() {

    while (cin >> n, n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) cout << abs(i - j) + 1 << ' ';
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}