from sort import *


def insert_sort(arr):
    i = 1
    while i < len(arr):
        if arr[i] < arr[i - 1]:
            tmp = arr[i]
            j = i - 1
            while j >= 0 and tmp < arr[j]:
                arr[j + 1] = arr[j]
                j = self_incr(j, -1)

            arr[j + 1] = tmp

        i = self_incr(i)


if __name__ == '__main__':
    arr = [12, 3, 5, 13, 12232, 57, 899, 22, 1, 32]

    insert_sort(arr)

    print(arr)
