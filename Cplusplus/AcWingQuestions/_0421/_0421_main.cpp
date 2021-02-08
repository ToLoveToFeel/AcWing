// Created by WXX on 2021/2/8 19:51
#include <iostream>

using namespace std;

int main() {

    int apple[10];
    for (int i = 0; i < 10; i++) cin >> apple[i];

    int height = 0;
    cin >> height;

    int res = 0;
    for (int i = 0; i < 10; i++)
        if (apple[i] <= height + 30)
            res++;

    cout << res << endl;

    return 0;
}
