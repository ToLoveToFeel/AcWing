#include <iostream>

using namespace std;

const int N = 110;

int n;

// 一行一行扩展
int main() {

    while (cin >> n, n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) cout << j << ' ';
            for (int j = i + 1; j <= n; j++) cout << j - i + 1 << ' ';
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}