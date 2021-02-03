// Created by WXX on 2021/2/3 15:37
#include <iostream>

using namespace std;

const int N = 10;

char g[N][N];
bool row[N][N], col[N][N], cell[3][3][N];

bool dfs(int x, int y) {
    if (y == 9) x++, y = 0;
    if (x == 9) {
        for (int i = 0; i < 9; i++) cout << g[i] << endl;
        return true;
    }

    if (g[x][y] != '.') return dfs(x, y + 1);
    for (int i = 0; i < 9; i++)
        if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
            g[x][y] = i + '1';
            row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
            if (dfs(x, y + 1)) return true;
            row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
            g[x][y] = '.';
        }
    return false;
}

int main() {

    for (int i = 0; i < 9; i++) {
        cin >> g[i];
        for (int j = 0; j < 9; j++)
            if (g[i][j] != '.') {
                int t = g[i][j] - '1';
                row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
            }
    }
    dfs(0, 0);
    return 0;
}
