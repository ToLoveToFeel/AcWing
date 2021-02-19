// Created by WXX on 2021/2/19 16:24
#include <iostream>

using namespace std;

const int N = 110;
bool st[N][N];  // 标记该格子是否被图上颜色，每个格子用左下角的坐标定义为该格子的坐标

int n;

int main() {

    cin >> n;
    while (n--) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int i = x1; i < x2; i++)
            for (int j = y1; j < y2; j++)
                st[i][j] = true;
    }

    int res = 0;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            res += st[i][j];

    cout << res << endl;
    return 0;
}
