#include <cstring>
#include <iostream>

using namespace std;

const int N = 510, M = 100010;

int n1, n2, m;  // n1表示第一个集合中的点数，n2表示第二个集合中的点数
int h[N], e[M], ne[M], idx;  // 邻接表存储所有边，匈牙利算法中只会用到从第一个集合指向第二个集合的边，所以这里只用存一个方向的边
int match[N];  // 存储第二个集合中的每个点当前匹配的第一个集合中的点是哪个
bool st[N];  // 表示第二个集合中的每个点是否已经被遍历过

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool find(int x) {
    // 遍历自己喜欢的女孩
    for (int i = h[x]; i != -1; i = ne[i]) {
        int j = e[i];
        if (!st[j]) {  // 如果在这一轮模拟匹配中,这个女孩尚未被预定
            st[j] = true;  // 那x就预定这个女孩了
            // 如果女孩j没有男朋友，或者她原来的男朋友能够预定其它喜欢的女孩。配对成功
            if (match[j] == 0 || find(match[j])) {
                match[j] = x;
                return true;
            }
        }
    }
    // 自己中意的全部都被预定了。配对失败。
    return false;
}

int main() {

    scanf("%d%d%d", &n1, &n2, &m);

    memset(h, -1, sizeof h);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b);
    }

    int res = 0;
    for (int i = 1; i <= n1; i++) {
        // 每轮模拟都要初始化，因为新来的男嘉宾可以随意选择女孩
        memset(st, false, sizeof st);
        if (find(i)) res++;
    }

    printf("%d\n", res);

    return 0;
}