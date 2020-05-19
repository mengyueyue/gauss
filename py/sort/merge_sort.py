# Created by mengyue on 2020/02/22.

from sort import self_incr


def merge_sort(arr, start, end):
    if start < end:
        mid = int((start + end) / 2)
        merge_sort(arr, start, mid)
        merge_sort(arr, mid + 1, end)
        merge(arr, start, mid, end)


def merge(arr, start, mid, end):
    i, j = start, mid + 1
    new_arr, new_index = [], 0
    while i <= mid and j <= end:
        if arr[i] <= arr[j]:
            new_arr.append(arr[i])
            i = self_incr(i)
        else:
            new_arr.append(arr[j])
            j = self_incr(j)
        new_index = self_incr(new_index)

    while i <= mid:
        new_arr.append(arr[i])
        i = self_incr(i)
        new_index = self_incr(new_index)

    while j <= end:
        new_arr.append(arr[j])
        j = self_incr(j)
        new_index = self_incr(new_index)

    while new_index > 0:
        new_index = self_incr(new_index, -1)
        arr[end] = new_arr[new_index]
        end = end - 1


if __name__ == '__main__':
    arr = [1, 5, 8, 12, 45, 132, 21, 56, 98, 22, 9, 4]

    merge_sort(arr, 0, len(arr) - 1)

    print(arr)
