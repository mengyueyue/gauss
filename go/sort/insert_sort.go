package main

import "fmt"

// insert sort
func main() {

	var arr = [] int{12, 34, 5, 122, 4, 1, 56, 7, 3, 78, 1}
	insert_sort(arr)
	fmt.Println(arr)
}

func insert_sort(arr []int) {

	var i, j int

	for i = 1; i < len(arr); i++ {

		if arr[i-1] > arr[i] {

			var tmp = arr[i]

			for j = i - 1; j >= 0 && arr[j] > tmp; j-- {
				arr[j+1] = arr[j]

			}

			arr[j+1] = tmp

		}
	}
}
