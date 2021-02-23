// Created by WXX on 2021/2/23 11:56
#include <iostream>

using namespace std;

const int N = 1010;

int n;
int s[N], f[N][N];

// 考点：区间DP，这题和AcWing 282代码完全一样
// AcWing 282 石子合并：https://www.acwing.com/problem/content/description/284/
// 本题时间复杂度为O(n^3)，值得一提的是，该题存在O(n^2)做法(进阶课)，也存在O(n*log(n))做法
// 这一题和 Huffman 树十分类似，不过限定了顺序不能变
int main() {

    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> s[i];
        s[i] += s[i - 1];
    }

    // 如果只有一个字母的话，不需要编码，返回0
    for (int len = 2; len <= n; len++) {
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            f[i][j] = 1e9;
            for (int k = i; k < j; k++)
                f[i][j] = min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
        }
    }
    cout << f[1][n] << endl;

    return 0;
}
