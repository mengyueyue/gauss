package util

func Swap(arr []int, i int, j int) {
	var tmp = arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
