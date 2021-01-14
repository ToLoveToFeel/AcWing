#include <iostream>
#include <queue>
#include <algorithm>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;
const int N = 25;

int n, m;  // 行数，列数
char g[N][N];

int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

// flood fill
int dfs(int x, int y) {

    int res = 1;
    g[x][y] = '#';
    for (int i = 0; i < 4; i++) {
        int a = x + dx[i], b = y + dy[i];
        if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] == '.')
            res += dfs(a, b);
    }

    return res;
}

int main() {

    while (cin >> m >> n, n || m) {
        for (int i = 0; i < n; i++) cin >> g[i];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (g[i][j] == '@') {
                    x = i, y = j;
                    break;
                }
        }
        cout << dfs(x, y) << endl;
    }
}
