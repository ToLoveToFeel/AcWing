// Created by WXX on 2021/2/19 15:43
#include <iostream>

using namespace std;

const int N = 510;

int n;
int a[N][N];

// 找规律
int main() {

    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            scanf("%d", &a[i][j]);

    for (int i = 2; i <= 2 * n; i++) {  // 遍历(x, y)的总和
        if (i % 2) {  // i为奇数，从右上遍历到左下
            for (int j = 1; j < i; j++)
                if (j >= 1 && j <= n && i - j >= 1 && i - j <= n)
                    printf("%d ", a[j][i - j]);
        } else {
            for (int j = i - 1; j; j--)
                if (j >= 1 && j <= n && i - j >= 1 && i - j <= n)
                    printf("%d ", a[j][i - j]);
        }
    }

    return 0;
}
