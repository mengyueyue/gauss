from sort import *


def bubble_sort(arr):
    i = 0
    length = len(arr)
    while i < length:

        j = i + 1
        boundary = length - 1

        while j <= boundary:

            if arr[i] > arr[j]:
                swap(arr, i, j)

            j = self_incr(j)

        i = self_incr(i)


if __name__ == '__main__':
    arr = [1, 3, 5, 13, 132, 789, 12, 4, 9]

    bubble_sort(arr)

    print(arr)
