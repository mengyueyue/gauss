package self.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-12-10.
 */
public class 堆排序 {


    @Test
    public void heapSort() {

        int[] array = {12, 43, 12, 56, 123, 6, 3, 1, 46, 4, 67, 124, 567, 3};


        for (int i = array.length / 2 - 1; i >= 0; i--) {

            adjustHeap(array, i, array.length);

        }

        for (int i = array.length - 1; i > 0; i--) {

            swap(array, 0, i);

            adjustHeap(array, 0, i);

        }

        System.out.println(Arrays.toString(array));



    }


    public void adjustHeap(int[] arr, int parent, int length) {

        for (int j = parent * 2 + 1; j < length; j = j * 2 + 1) {

            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }

            if (arr[j] <= arr[parent]) {
                break;
            }

            swap(arr, parent, j);

            parent = j;

        }

    }


    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
