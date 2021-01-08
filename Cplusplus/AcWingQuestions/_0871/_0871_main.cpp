#include <iostream>
#include <unordered_map>

using namespace std;

typedef long long LL;

const int mod = 1e9 + 7;

int main() {

    int n;
    cin >> n;

    unordered_map<int, int> cnt;  // (质因子，质因子个数)
    while (n--) {
        int x;
        cin >> x;

        for (int i = 2; i <= x / i; i++)
            while (x % i == 0) {
                x /= i;
                cnt[i]++;
            }
        if (x > 1) cnt[x]++;
    }

    LL res = 1;
    for (auto t : cnt) {
        int p = t.first, a = t.second;
        LL s = 1;
        while (a--) s = (s * p + 1) % mod;  // 秦九韶算法
        res = res * s % mod;
    }
    cout << res << endl;

    return 0;
}