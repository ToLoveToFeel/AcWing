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
    nth_element(a, a + n / 2, a + n);  // a[n/2]就是排好序，第n/2+1小的元素
    int res = 0;
    for (int i = 0; i < n; i++) res += abs(a[i] - a[n / 2]);
    cout << res << endl;

    return 0;
}