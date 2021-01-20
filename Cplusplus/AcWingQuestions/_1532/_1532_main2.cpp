#include <iostream>
#include <unordered_set>
#include <algorithm>

using namespace std;

const int N = 100010;

int n, m;
int q[N];

// 双指针做法，时间复杂度：O(n*log(n))
int main() {

    scanf("%d%d", &n, &m);

    for (int i = 0; i < n; i++) scanf("%d", &q[i]);
    sort(q, q + n);

    for (int i = 0, j = n - 1; i < j; i++) {
        while (i < j && q[i] + q[j] > m) j--;
        if (i < j && q[i] + q[j] == m) {
            printf("%d %d\n", q[i], q[j]);
            return 0;
        }
    }

    puts("No Solution");

    return 0;
}