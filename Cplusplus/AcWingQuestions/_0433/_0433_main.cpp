// Created by WXX on 2021/2/6 20:55
#include <iostream>

using namespace std;

int main() {

    string str;
    cin >> str;

    int sum = 0;
    for (int i = 0, j = 1; i + 1 < str.size(); i++)
        if (str[i] != '-') {
            sum += (str[i] - '0') * j;
            j++;
        }
    sum %= 11;

    char c = 'X';
    if (sum < 10) c = '0' + sum;
    if (c == str.back()) puts("Right");
    else {
        str.back() = c;
        cout << str << endl;
    }

    return 0;
}
