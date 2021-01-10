#include <iostream>
#include <algorithm>

using namespace std;

const int N = 100010;

int n;
int a[N];

// 绝对值不等式
int main() {

    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);
    int res = 0;
    for (int i = 0; i < n; i++) res += a[i] - a[i / 2];  // 可以证明改为i是等价的
    cout << res << endl;

    return 0;
}