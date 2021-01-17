#include <iostream>
#include <algorithm>

using namespace std;

const int N = 110;

int n, m;
struct Segment {
    int l, r;
    bool operator< (const Segment &t) const {
        return l < t.l;
    }
} seg[N];

// 区间合并
int main() {

    cin >> n >> m;

    for (int i = 0; i < m; i++) cin >> seg[i].l >> seg[i].r;
    sort(seg, seg + m);

    int sum = 0;
    int L = seg[0].l, R = seg[0].r;
    for (int i = 1; i < m; i++) {
        if (seg[i].l <= R) R = max(R, seg[i].r);
        else {
            sum += R - L + 1;
            L = seg[i].l, R = seg[i].r;
        }
    }
    sum += R - L + 1;

    cout << n + 1 - sum << endl;
}