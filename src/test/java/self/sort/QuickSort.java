package self.sort;

import java.util.Arrays;

/**
 * Created by mengyue on 2020-05-14.
 */
public class QuickSort {


    public static void main(String[] args) {


        int[] array1 = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};

        new QuickSort().quickSort(array1, 0, array1.length - 1);

        System.out.println(Arrays.toString(array1));

    }


    public void quickSort(int[] items, int start, int end) {

        if (start < end) {
            int pivot = items[start], i = start, j = start + 1;

            while (j <= end) {

                if (items[j] < pivot) {
                    i++;
                    swap(items, i, j);
                }
                j++;
            }

            swap(items, start, i);
            quickSort(items, start, i - 1);
            quickSort(items, i + 1, end);

        }

    }

    private void swap(int[] items, int i, int j) {

        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;

    }

}
