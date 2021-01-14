#include <iostream>
#include <algorithm>

using namespace std;

/**
 * 短除法
 */
// 得到数字x的表示，比如 x = 11，应该返回字母B
char get(int x) {
    if (x <= 9) return x + '0';
    return x - 10 + 'A';
}

// 十进制的数字n ==> b进制转下对应的数字
string base(int n, int b) {
    string num;
    while (n) num += get(n % b), n /= b;
    reverse(num.begin(), num.end());
    return num;
}

// 判断字符串是否为回文串
bool check(string num) {
    for (int i = 0, j = num.size() - 1; i < j; i++, j--)
        if (num[i] != num[j])
            return false;
    return true;
}

int main() {

    int b;
    cin >> b;
    for (int i = 1; i <= 300; i++) {
        auto num = base(i * i, b);  // 将i*i转换为b进制数据
        if (check(num)) cout << base(i, b) << ' ' << num << endl;
    }

    return 0;
}
