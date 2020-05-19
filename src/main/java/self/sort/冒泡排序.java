package self.sort;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-06-25.
 */
public class 冒泡排序 {


    public static void main(String[] args) {


        int[] array = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        int[] arrayFlag = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        bubbleSort(array);
        bubbleSortFlag(arrayFlag);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayFlag));

    }


    public static void bubbleSort(int[] arr) {

        int length = arr.length;

        int boundary = length - 1;

        for (int i = 0; i < length; i++) {

            for (int j = 1; j <= boundary; j++) {

                //符合条件 做交换
                if (arr[j - 1] < arr[j]) { // 升序: arr[j-1] > arr[j]  降序: arr[j-1] <  arr[j]

                    int tmp = arr[j - 1];

                    arr[j - 1] = arr[j];

                    arr[j] = tmp;
                }

            }

            boundary--;

        }

    }

    /**
     *
     * 针对某些情况下 已经排序好的 但还在循环的情况
     *
     * 设置一个flag 来判断这种情况
     *
     * @param arr
     */
    public static void bubbleSortFlag(int[] arr) {

        int compareRange = arr.length - 1;

        int tmp = 0 ;

        boolean flag = true;

        while (flag) {

            flag = false;

            for (int i = 1; i <= compareRange; i++) {

                if (arr[i - 1] > arr[i]) {
                    tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    flag = true;

                }

            }

            compareRange--;
        }

    }

}
