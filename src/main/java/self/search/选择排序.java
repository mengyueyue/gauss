package self.search;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-06-26.
 */
public class 选择排序 {

    public static void main(String[] args) {

        int[] array = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        selectSort(array);
        System.out.println(Arrays.toString(array));

    }

    /**
     *
     * 选择排序是在无序序列中 选择最小的然后 放到 有序序列的最右边
     *
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {

        int len = arr.length;
        int tmp;
        int minIndex;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i; j < len - 1; j++) {
                if (arr[minIndex] > arr[j + 1]) {// 升序排列
                    minIndex = j + 1;
                }
            }

            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

    }

}
