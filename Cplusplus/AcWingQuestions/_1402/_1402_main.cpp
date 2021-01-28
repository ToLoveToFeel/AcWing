// Created by WXX on 2021/1/28 22:41
#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;

const int N = 110;
const double eps = 1e-6;

int n, m;
char g[N][N];
PII q[N * N];
int top;  // 记录连通块中格子数量

double get_dist(PII a, PII b) {
    double dx = a.x - b.x;
    double dy = a.y - b.y;
    return sqrt(dx * dx + dy * dy);
}

double get_hash() {
    double sum = 0;
    for (int i = 0; i < top; i++)
        for (int j = i + 1; j < top; j++)
            sum += get_dist(q[i], q[j]);
    return sum;
}

char get_id(double key) {
    static double hash[30];
    static int id = 0;
    for (int i = 0; i < id; i++)
        if (fabs(hash[i] - key) < eps)
            return i + 'a';
    hash[id++] = key;
    return id - 1 + 'a';
}

// floodfill
void dfs(int a, int b) {
    q[top++] = {a, b};
    g[a][b] = '0';
    for (int i = a - 1; i <= a + 1; i++)
        for (int j = b - 1; j <= b + 1; j++) {
            if (i == a && j == b) continue;
            if (i >= 0 && i < n && j >= 0 && j < m && g[i][j] == '1')
                dfs(i, j);
        }
}

int main() {

    cin >> m >> n;
    for (int i = 0; i < n; i++) cin >> g[i];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (g[i][j] == '1') {
                top = 0;
                dfs(i, j);
                char c = get_id(get_hash());  // 获得对应图形的哈希值，然后根据哈希值获得应该填写的字符
                for (int k = 0; k < top; k++)
                    g[q[k].x][q[k].y] = c;
            }

    for (int i = 0; i < n; i++) cout << g[i] << endl;

    return 0;
}
