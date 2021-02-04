// Created by WXX on 2021/2/4 13:29
#include <iostream>
#include <cstring>
#include <queue>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;
const int N = 210;

int n, m;
char g[N][N];
int dist[N][N];

int bfs(PII start) {

    queue<PII> q;
    q.push(start);
    memset(dist, -1, sizeof dist);
    dist[start.x][start.y] = 0;

    int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

    while (q.size()) {
        auto t = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int x = t.x + dx[i], y = t.y + dy[i];
            if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] != '#' && dist[x][y] == -1) {
                dist[x][y] = dist[t.x][t.y] + 1;
                if (g[x][y] == 'E') return dist[x][y];
                q.push({x, y});
            }
        }
    }
    return -1;
}

int main() {

    int T;
    cin >> T;
    while (T--) {
        cin >> n >> m;

        PII start;
        for (int i = 0; i < n; i++) {
            cin >> g[i];
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'S') start = {i, j};
            }
        }

        int res = bfs(start);
        if (res == -1) puts("oop!");
        else cout << res << endl;
    }

    return 0;
}
