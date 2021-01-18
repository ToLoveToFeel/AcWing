#include <iostream>
#include <algorithm>

using namespace std;

const int N = 310;

int n;

// 重载小于号
struct Person {
    int id, sum, a, b, c;  // a, b, c分别代表语文、数学、英语
    bool operator<(const Person &t) const {
        if (sum != t.sum) return sum > t.sum;  // 大的在前面
        if (a != t.a) return a > t.a;
        return id < t.id;
    }
} q[N];

int main() {

    cin >> n;
    for (int i = 1; i <= n; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        q[i] = {i, a + b + c, a, b, c};
    }

    sort(q + 1, q + n + 1);

    for (int i = 1; i <= 5; i++)
        cout << q[i].id << ' ' << q[i].sum << endl;

    return 0;
}