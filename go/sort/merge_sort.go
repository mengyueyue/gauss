/**
Created by mengyue on 2020/02/22.
*/

package main

import "fmt"

func main() {

	var arr = [] int{1, 4, 14, 12, 5, 89, 34, 122, 4, 89, 9}

	merge_sort(arr, 0, len(arr)-1)

	fmt.Println(arr)
}

func merge_sort(arr []int, start int, end int) {

	if start < end {
		mid := (start + end) / 2
		merge_sort(arr, start, mid)
		merge_sort(arr, mid+1, end)
		merge(arr, start, mid, end)
	}
}

func merge(arr []int, start int, mid int, end int) {

	i, j := start, mid+1
	tmp_arr, tmp_idx := []int{}, 0

	for ; i <= mid && j <= end; {
		if arr[i] <= arr[j] {
			tmp_arr = append(tmp_arr, arr[i])
			i++
		} else {
			tmp_arr = append(tmp_arr, arr[j])
			j++
		}
		tmp_idx++
	}

	for ; i <= mid; {
		tmp_arr = append(tmp_arr, arr[i])
		tmp_idx++
		i++
	}

	for ; j <= end; {
		tmp_arr = append(tmp_arr, arr[j])
		tmp_idx++
		j++
	}
	for ; tmp_idx > 0; end, tmp_idx = end-1, tmp_idx-1 {
		arr[end] = tmp_arr[tmp_idx-1]
	}

}
