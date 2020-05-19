from sort import *


def quick_sort(arr, start, end):
    if start < end:
        pivot, i, j = arr[start], start, start + 1
        while j <= end:
            if pivot > arr[j]:
                i = i + 1
                swap(arr, i, j)
            j = j + 1

        swap(arr, start, i)
        quick_sort(arr, start, i - 1)
        quick_sort(arr, i + 1, end)

def swap(arr, i, j):
    tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp

if __name__ == '__main__':
    arr = [13, 55, 3, 22, 132, 456, 78, 1, 6]

    quick_sort(arr, 0, len(arr) - 1)

    print(arr)
