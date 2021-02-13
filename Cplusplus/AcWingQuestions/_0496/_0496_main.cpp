// Created by WXX on 2021/2/13 10:55
#include <iostream>
#include <queue>

using namespace std;

const int N = 1010;

int m, n;
bool st[N];  // 记录数字是否在缓存中
queue<int> q;

int main() {

    cin >> m >> n;
    int res = 0;
    while (n--) {
        int x;
        cin >> x;
        if (!st[x]) {
            if (q.size() == m) {
                st[q.front()] = false;
                q.pop();
            }
            q.push(x);
            st[x] = true;
            res++;
        }
    }
    cout << res << endl;

    return 0;
}
