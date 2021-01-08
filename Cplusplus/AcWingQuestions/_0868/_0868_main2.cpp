#include <iostream>

using namespace std;

const int N = 1000010;

int cnt = 0;
int p[N];  // 从前往后存储素数，p[j] = i 说明 i 是素数
bool st[N];  // st[x]存储x是否被筛掉，为true代表是合数

// 线性筛法求素数  O(n)
void get_primes(int n) {
    for (int i = 2; i <= n; i++) {
        if (!st[i]) p[cnt++] = i;
        for (int j = 0; p[j] <= n / i; j++) {
            st[p[j] * i] = true;
            if (i % p[j] == 0) break;
        }
    }
}

int main() {

    int n;
    cin >> n;

    get_primes(n);

    cout << cnt << endl;

    return 0;
}