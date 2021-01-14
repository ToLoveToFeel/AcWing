# 算法基础课 Level-2

## 1 基础算法

### 1.1 快排

```c++
void quick_sort(int q[], int l, int r) {
    
    if (l >= r) return;
    int x = q[l], i = l - 1, j = r + 1;
    while (i < j) {
        while(q[++i] < x);
        while(q[--j] > x);
        if (i < j) swap(q[i], q[j]);
    }
    
    quick_sort(q, l, j);
    quick_sort(q, j + 1, r);
}
```

```c++
void quick_sort(int q[], int l, int r) {
    
    if (l >= r) return;
    int x = q[(l + r + 1) / 2], i = l - 1, j = r + 1;
    while (i < j) {
        while(q[++i] < x);
        while(q[--j] > x);
        if (i < j) swap(q[i], q[j]);
    }
    
    quick_sort(q, l, i - 1);
    quick_sort(q, i, r);
}
```







