from sort import *


def select_sort(arr):
    i = 0
    length = len(arr)
    while i < length:
        j = i
        minIndex = i
        while j < length - 1:
            if arr[minIndex] > arr[j + 1]:
                minIndex = j + 1
            j = self_incr(j)

        swap(arr, i, minIndex)

        i = self_incr(i)


if __name__ == '__main__':
    arr = [12, 34, 11, 35, 54, 1, 5, 78, 3]

    select_sort(arr)

    # print(dir(_thread))
    print(arr)
