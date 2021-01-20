#include <iostream>

using namespace std;

// 打表
int month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // month[1]=31代表一月31天
int weekday[7];  // weekday[0]表示周一出现的次数

int main() {

    int n;
    cin >> n;

    int days = 0;
    for (int year = 1900; year < 1900 + n; year++) {
        for (int i = 1; i <= 12; i++) {
            weekday[(days + 12 + 0) % 7]++;  // +0代表1900-1-1是周一，应该存储在weekday[0]中
            days += month[i];
            if (i == 2) {
                if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) days++;
            }
        }
    }

    for (int i = 5, j = 0; j < 7; i = (i + 1) % 7, j++)
        cout << weekday[i] << ' ';
    cout << endl;

    return 0;
}