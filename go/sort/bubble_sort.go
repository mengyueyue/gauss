package main

import (
	"fmt"
	"go/util"
)

func main() {

	arr := []int{1, 43, 132, 5, 89, 122, 546, 8, 9}

	bubble_sort(arr)

	fmt.Println(arr)
}

func bubble_sort(arr []int) {

	var i int
	for ; i < len(arr); i++ {

		var j = i + 1
		var boundary = len(arr) - 1

		for ; j <= boundary; j++ {

			if arr[i] > arr[j] {
				util.Swap(arr, i, j)
			}
		}

		boundary--

	}
}
