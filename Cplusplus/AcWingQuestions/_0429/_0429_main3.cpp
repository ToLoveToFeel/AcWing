#include <iostream>
#include <algorithm>

using namespace std;

const int N = 310;

int n;

struct Person {
    int id, sum, a, b, c;  // a, b, c分别代表语文、数学、英语
} q[N];

int main() {

    cin >> n;
    for (int i = 1; i <= n; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        q[i] = {i, a + b + c, a, b, c};
    }

    // lambda表达式写法
    sort(q + 1, q + n + 1, [](Person &a, Person &b) {
        if (a.sum != b.sum) return a.sum > b.sum;
        if (a.a != b.a) return a.a > b.a;
        return a.id < b.id;
    });

    for (int i = 1; i <= 5; i++)
        cout << q[i].id << ' ' << q[i].sum << endl;

    return 0;
}