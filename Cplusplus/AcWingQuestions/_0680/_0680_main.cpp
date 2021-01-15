#include <iostream>

using namespace std;

const int N = 100010;

int n, m;
int w[N];

bool check(double mid) {
    int cnt = 0;
    for (int i = 0; i < n; i++)
        cnt += w[i] / mid;
    return cnt >= m;
}

int main() {

    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> w[i];

    double l = 0, r = 1e9;
    while (r - l > 1e-4) {
        double mid = (l + r) / 2;
        if (check(mid)) l = mid;
        else r = mid;
    }

    printf("%.2lf\n", r);
    return 0;
}