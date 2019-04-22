package self.search;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/2.
 */
public class 归并排序 {


    public static void main(String[] args) {

        int[] array = new int[]{12, 3, 4, 123, 13, 13, 13, 345, 24, 66, 14, 7, 16, 98, 2};
        mergeSortRecursion(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }


    public static void mergeSortRecursion(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortRecursion(array, start, mid);
        mergeSortRecursion(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            temp[index++] = array[i] > array[j] ? array[j++] : array[i++];
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= end) {
            temp[index++] = array[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            array[start++] = temp[k];
        }
    }
}
