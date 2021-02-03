// Created by WXX on 2021/2/3 15:01
#include <iostream>
#include <cstring>

using namespace std;

const int N = 40;

int n, m;
int w[N][N];
int st[N];

bool check_row() {
    for (int i = 0; i < m; i++) {
        memset(st, 0, sizeof st);
        for (int j = 0; j < m; j++) {
            int t = w[i][j];
            if (t < 1 || t > m) return false;
            if (st[t]) return false;
            st[t] = true;
        }
    }
    return true;
}

bool check_col() {
    for (int i = 0; i < m; i++) {
        memset(st, 0, sizeof st);
        for (int j = 0; j < m; j++) {
            int t = w[j][i];
            if (t < 1 || t > m) return false;
            if (st[t]) return false;
            st[t] = true;
        }
    }
    return true;
}

bool check_cell() {
    for (int x = 0; x < m; x += n)
        for (int y = 0; y < m; y += n) {
            memset(st, 0, sizeof st);
            for (int dx = 0; dx < 3; dx++)
                for (int dy = 0; dy < 3; dy++) {
                    int t = w[x + dx][y + dy];
                    if (t < 1 || t > m) return false;
                    if (st[t]) return false;
                    st[t] = true;
                }
        }
    return true;
}

int main() {

    int T;
    scanf("%d", &T);
    for (int C = 1; C <= T; C++) {
        scanf("%d", &n);
        m = n * n;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                scanf("%d", &w[i][j]);

        if (check_row() && check_col() && check_cell())
            printf("Case #%d: Yes\n", C);
        else
            printf("Case #%d: No\n", C);
    }

    return 0;
}
