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
    for (auto t : cnt) res = res * (t.second + 1) % mod;
    cout << res << endl;

    return 0;
}