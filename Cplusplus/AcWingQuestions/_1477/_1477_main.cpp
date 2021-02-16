// Created by WXX on 2021/2/16 20:02
#include <iostream>

using namespace std;

int main() {

    string num;
    cin >> num;
    int sum = 0;
    for (auto c : num) sum += c - '0';

    string str = to_string(sum);
    string name[] = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };
    for (auto c : str) cout << name[c - '0'] << ' ';

    return 0;
}
