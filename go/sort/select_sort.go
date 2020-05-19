package main

import (
	"fmt"
	"go/util"
)

func main() {

	var arr = []int{12, 4, 6, 2, 5, 1, 35, 78, 21, 9}

	select_sort(arr)

	fmt.Println(arr)

}

func select_sort(arr []int) {

	var i int
	for ; i < len(arr); i++ {
		var j, minIndex = i, i

		for ; j < len(arr)-1; j++ {

			if arr[minIndex] > arr[j+1] {
				minIndex = j + 1
			}

		}

		util.Swap(arr, minIndex, i)
	}

}
