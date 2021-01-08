#include <iostream>

using namespace std;

const int N = 1000010;

int cnt = 0;
bool st[N];  // st[x]存储x是否被筛掉，为true代表是合数

// 埃式算法
void get_primes(int n) {
    for (int i = 2; i <= n; i++) {
        if (st[i]) continue;  // 只需要筛除质数的倍数即可
        cnt++;
        for (int j = i + i; j <= n; j += i) st[j] = true;
    }
}

int main() {

    int n;
    cin >> n;

    get_primes(n);

    cout << cnt << endl;

    return 0;
}