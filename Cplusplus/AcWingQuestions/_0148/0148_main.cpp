// Created by WXX on 2021/2/15 17:58
#include <iostream>
#include <queue>

using namespace std;

int main() {

    int n;
    cin >> n;
    priority_queue<int, vector<int>, greater<int>> heap;
    while (n--) {
        int x;
        cin >> x;
        heap.push(x);
    }

    int res = 0;
    while (heap.size() > 1) {
        int x = heap.top();
        heap.pop();
        int y = heap.top();
        heap.pop();
        res += x + y;
        heap.push(x + y);
    }

    cout << res << endl;
    return 0;
}
