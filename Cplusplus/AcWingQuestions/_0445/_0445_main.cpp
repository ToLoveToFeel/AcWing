// Created by WXX on 2021/2/15 18:07
#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    string str;
    cin >> str;

    // 翻转字符串
    reverse(str.begin(), str.end());
    // 处理'-'
    if (str.back() == '-') {
        cout << '-';
        str.pop_back();
    }
    // 处理前导0
    int k = 0;
    while (k + 1 < str.size() && str[k] == '0') k++;
    while (k < str.size()) cout << str[k++];
    return 0;
}
