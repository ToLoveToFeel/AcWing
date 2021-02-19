// Created by WXX on 2021/2/19 16:52
#include <iostream>
#include <cstring>
#include <queue>

#define x first
#define y second

using namespace std;

typedef long long LL;
typedef pair<int, int> PII;
const int N = 1010;

int n, m, k, d;  // 方格图的大小、栋栋的分店数量、客户的数量，以及不能经过的点的数量
bool g[N][N];  // 如果(i, j)有障碍物，则g[i][j] = true
int dist[N][N];  // 多源最短路径
queue<PII> q;
struct Target {  // 客户位置(x, y)，送餐次数c
    int x, y, c;
} tg[N * N];

void bfs() {

    int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

    while (q.size()) {
        auto t = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int x = t.x + dx[i], y = t.y + dy[i];
//            if (x < 1 || x > n || y < 1 || y > n || g[x][y]) continue;
//            if (dist[x][y] > dist[t.x][t.y] + 1) {  // 这句话保证了(x, y)没有被访问过
//                dist[x][y] = dist[t.x][t.y] + 1;
//                q.push({x, y});
//            }
            // 下面的写法也是正确的
            if (x >= 1 && x <= n && y >= 1 && y <= n && !g[x][y] && dist[x][y] == 0x3f3f3f3f) {
                dist[x][y] = dist[t.x][t.y] + 1;
                q.push({x, y});
            }
        }
    }
}

int main() {

    scanf("%d%d%d%d", &n, &m, &k, &d);
    memset(dist, 0x3f, sizeof dist);
    while (m--) {  // 读入分店位置
        int x, y;
        scanf("%d%d", &x, &y);
        dist[x][y] = 0;
        q.push({x, y});
    }
    for (int i = 0; i < k; i++)  // 读入客户
        scanf("%d%d%d", &tg[i].x, &tg[i].y, &tg[i].c);
    while (d--) {  // 读入障碍物
        int x, y;
        scanf("%d%d", &x, &y);
        g[x][y] = true;
    }
    bfs();

    LL res = 0;
    for (int i = 0; i < k; i++)
        res += dist[tg[i].x][tg[i].y] * tg[i].c;
    printf("%lld\n", res);  // 注意是：%lld  !!!!!!
    return 0;
}
