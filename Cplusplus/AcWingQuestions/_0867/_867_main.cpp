#include <iostream>

using namespace std;

void divide(int x) {
    for (int i = 2; i <= x / i; i++)
        if (x % i == 0) {  // 条件满足的话，i一定是质数
            int s = 0;  // 记录该质因子的个数
            while (x % i == 0) x /= i, s++;
            printf("%d %d\n", i, s);
        }
    if (x > 1) printf("%d 1\n", x);
}

int main() {

    int n;
    scanf("%d", &n);

    while (n--) {
        int x;
        scanf("%d", &x);
        divide(x);
        printf("\n");
    }

    return 0;
}