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

### 1.2归并排序

```c++
void merge_sort(int q[], int l, int r) {

    if (l >= r) return;

    int mid = l + r >> 1;

    merge_sort(q, l, mid), merge_sort(q, mid + 1, r);

    int k = 0, i = l, j = mid + 1;
    while (i <= mid && j <= r)
        if (q[i] <= q[j]) tmp[k++] = q[i++];
        else tmp[k++] = q[j++];

    while (i <= mid) tmp[k++] = q[i++];
    while (j <= r) tmp[k++] = q[j++];

    for (i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
}
```







