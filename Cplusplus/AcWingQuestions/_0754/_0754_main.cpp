#include <iostream>

using namespace std;

const int N = 110;

int n;
int a[N][N];

// 从a[i][i]向右向下扩展
int main() {

    while (cin >> n, n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i, k = 1; j <= n; j++, k++) {
                a[i][j] = k;
                a[j][i] = k;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                cout << a[i][j] << " ";
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}