#include <iostream>
#include <unordered_set>

using namespace std;

const int INF = 10000;

// 哈希表做法，时间复杂度：O(n)
int main() {

    int n, m;
    scanf("%d%d", &n, &m);
    unordered_set<int> hash;

    int v1 = INF, v2;
    for (int i = 0; i < n; i++) {
        int a, b;
        scanf("%d", &a);
        b = m - a;
        if (hash.count(b)) {
            if (a > b) swap(a, b);
            if (a < v1) v1 = a, v2 = b;
        }
        hash.insert(a);
    }

    if (v1 == INF) puts("No Solution");
    else printf("%d %d\n", v1, v2);

    return 0;
}