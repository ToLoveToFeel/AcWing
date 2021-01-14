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
int bfs(int sx, int sy) {

    queue<PII> q;
    q.push({sx, sy});
    g[sx][sy] = '#';
    int res = 0;

    while (q.size()) {
        auto t = q.front();
        q.pop();
        res++;
        for (int i = 0; i < 4; i++) {
            int x = t.x + dx[i], y = t.y + dy[i];
            if (x < 0 || x >= n || y < 0 || y >= m || g[x][y] != '.') continue;
            g[x][y] = '#';
            q.push({x, y});
        }
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
        cout << bfs(x, y) << endl;
    }
}
