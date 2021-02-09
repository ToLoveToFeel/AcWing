// Created by WXX on 2021/2/8 22:02
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 16, M = N * N + 1;

int ones[1 << N];  // 存储每个数的二进制表示中有多少个1，例如ones[5] = 2
int log[1 << N];  // 存储数据的log值
int state[N][N];  // 每个空格的备选数字(A~P)，用二进制表示，二进制是1表示可选，最低位代表A
char str[N][N + 1];  // 存储数独的初始状态

int bstate[M][N][N], bstate2[M][N][N];  // 回溯(恢复现场)的时候使用
char bstr[M][N][N + 1];  // 棋盘状态的备份，回溯的时候使用

inline int lowbit(int x) {  // inline：加速调用过程
    return x & -x;
}

void draw(int x, int y, int c) {  // 在str[i][j]中填写字母(c + 'A')
    str[x][y] = c + 'A';
    // 更新行、列
    for (int i = 0; i < N; i++) {
        state[x][i] &= ~(1 << c);  // 将第c位置零，相当于：state[x][i] &= ~(1 << c)
        state[i][y] &= ~(1 << c);
    }
    // 更新十六宫格
    int sx = x / 4 * 4, sy = y / 4 * 4;  // 十六宫格的左上角
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++)
            state[sx + i][sy + j] &= ~(1 << c);
    }
    // 更新(x, y)这个格子所代表的的状态
    state[x][y] = 1 << c;
}

bool dfs(int cnt) {

    if (!cnt) return true;
    /**
     * 枚举的过程
     */
    // 存储此时的状态，方便恢复现场
    int kcnt = cnt;
    memcpy(bstate[kcnt], state, sizeof state);
    memcpy(bstr[kcnt], str, sizeof str);

    // 对于每个空格，如果一个字母都不能填，则无解；如果只能填写一个字母，则直接填
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            if (str[i][j] == '-') {
                int s = state[i][j];
                if (!s) {  // 说明一个字母都不能填写
                    memcpy(state, bstate[kcnt], sizeof state);
                    memcpy(str, bstr[kcnt], sizeof str);
                    return false;
                }
                if (ones[s] == 1) {
                    draw(i, j, log[s]);
                    cnt--;
                }
            }
    }

    // 对于每一行，如果某个字母不能出现在任何一个位置，则无解；
    // 如果某个字母，只能填在一个位置上，则直接填
    for (int i = 0; i < N; i++) {
        int sor = 0;  // sor中存储的是当前这一行可以备选方案的并集
        int sand = (1 << N) - 1;  // 某一位如果是1，表示这个字母只能在这一行出现一次
        int drawn = 0;  // 当前这一行已经填上的格子是哪些字母
        for (int j = 0; j < N; j++) {
            int s = state[i][j];
            sand &= ~(sor & s);;  // s & sor的结果中如果某一位是1，表示某个字母可以在该行中填写两次
            sor |= s;
            if (str[i][j] != '-') drawn |= state[i][j];
        }
        if (sor != (1 << N) - 1) {
            memcpy(state, bstate[kcnt], sizeof state);
            memcpy(str, bstr[kcnt], sizeof str);
            return false;
        }
        for (int j = sand; j; j -= lowbit(j)) {  // 如果某个字母，只能填在一个位置上，则直接填
            int t = lowbit(j);
            if (!(drawn & t)) {  // 如果这个字母没有填过的话，才填写该字母
                for (int k = 0; k < N; k++)  // 判断应该将字母log[t]+'A'填写到哪个位置
                    if (state[i][k] & t) {
                        draw(i, k, log[t]);
                        cnt--;
                    }
            }
        }
    }

    // 对于每一列，如果某个字母不能出现在任何一个位置，则无解；
    // 如果某个字母，只能填在一个位置上，则直接填
    for (int i = 0; i < N; i++) {
        int sor = 0;  // sor中存储的是当前这一行可以备选方案的并集
        int sand = (1 << N) - 1;  // 某一位如果是1，表示这个字母只能在这一行出现一次
        int drawn = 0;  // 当前这一行已经填上的格子是哪些字母
        for (int j = 0; j < N; j++) {
            int s = state[j][i];
            sand &= ~(sor & s);;  // s & sor的结果中如果某一位是1，表示某个字母可以在该行中填写两次
            sor |= s;
            if (str[j][i] != '-') drawn |= state[j][i];
        }
        if (sor != (1 << N) - 1) {
            memcpy(state, bstate[kcnt], sizeof state);
            memcpy(str, bstr[kcnt], sizeof str);
            return false;
        }
        for (int j = sand; j; j -= lowbit(j)) {  // 如果某个字母，只能填在一个位置上，则直接填
            int t = lowbit(j);
            if (!(drawn & t)) {  // 如果这个字母没有填过的话，才填写该字母
                for (int k = 0; k < N; k++)  // 判断应该将字母log[t]+'A'填写到哪个位置
                    if (state[k][i] & t) {
                        draw(k, i, log[t]);
                        cnt--;
                    }
            }
        }
    }

    // 对于每个16宫格，如果某个字母不能出现在任何一个位置，则无解；
    // 如果某个字母，只能填在一个位置上，则直接填
    for (int i = 0; i < N; i++) {  // i表示16宫格的编号
        int sor = 0;  // sor中存储的是当前这一行可以备选方案的并集
        int sand = (1 << N) - 1;  // 某一位如果是1，表示这个字母只能在这一行出现一次
        int drawn = 0;  // 当前这一行已经填上的格子是哪些字母
        for (int j = 0; j < N; j++) {  // y表示枚举在16宫格的位置
            int sx = i / 4 * 4, sy = i % 4 * 4;
            int dx = j / 4, dy = j % 4;
            int s = state[sx + dx][sy + dy];
            sand &= ~(sor & s);;  // s & sor的结果中如果某一位是1，表示某个字母可以在该行中填写两次
            sor |= s;
            if (str[sx + dx][sy + dy] != '-') drawn |= state[sx + dx][sy + dy];
        }
        if (sor != (1 << N) - 1) {
            memcpy(state, bstate[kcnt], sizeof state);
            memcpy(str, bstr[kcnt], sizeof str);
            return false;
        }
        for (int j = sand; j; j -= lowbit(j)) {  // 如果某个字母，只能填在一个位置上，则直接填
            int t = lowbit(j);
            if (!(drawn & t)) {  // 如果这个字母没有填过的话，才填写该字母
                for (int k = 0; k < N; k++) {  // 判断应该将字母log[t]+'A'填写到哪个位置
                    int sx = i / 4 * 4, sy = i % 4 * 4;
                    int dx = k / 4, dy = k % 4;
                    if (state[sx + dx][sy + dy] & t) {
                        draw(sx + dx, sy + dy, log[t]);
                        cnt--;
                    }
                }
            }
        }
    }

    if (!cnt) return true;

    // 每次选择方案时，选择备选方案最少的格子来填
    int x, y, s = 100;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            if (str[i][j] == '-' && ones[state[i][j]] < s) {
                s = ones[state[i][j]];
                x = i, y = j;
            }
    }

    memcpy(bstate2[kcnt], state, sizeof state);
    for (int i = state[x][y]; i; i -= lowbit(i)) {
        memcpy(state, bstate2[kcnt], sizeof state);
        draw(x, y, log[lowbit(i)]);
        if (dfs(cnt - 1)) return true;
    }

    memcpy(state, bstate2[kcnt], sizeof state);
    memcpy(str, bstr[kcnt], sizeof str);

    return false;
}

int main() {

    // 初始化log数组，ones数组
    for (int i = 0; i < N; i++) log[1 << i] = i;
    for (int i = 0; i < 1 << N; i++) {
        for (int j = i; j; j -= lowbit(j)) ones[i]++;
    }

    // 多组测试数据
    while (cin >> str[0]) {
        for (int i = 1; i < N; i++) cin >> str[i];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                state[i][j] = (1 << N) - 1;
        }
        int cnt = 0;  // 存储需要填写的空格的个数
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (str[i][j] != '-') draw(i, j, str[i][j] - 'A');
                else cnt++;
        }

        dfs(cnt);
        for (int i = 0; i < N; i++) cout << str[i] << endl;
        cout << endl;
    }

    return 0;
}