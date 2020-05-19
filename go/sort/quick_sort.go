package main

import (
	"fmt"
	"go/util"
)

func main() {

	var arr = []int{13, 55, 3, 22, 132, 456, 78, 1, 6}

	quick_sort(arr, 0, len(arr)-1)

	fmt.Println(arr)

}

func quick_sort(arr []int, start int, end int) {

	if start < end {

		var pivot, i, j = arr[start], start, start + 1

		for ; j <= end; j++ {

			if pivot > arr[j] {
				i++
				util.Swap(arr, i, j)

			}

		}

		util.Swap(arr, i, start)
		quick_sort(arr, start, i-1)
		quick_sort(arr, i+1, end)

	}

}
