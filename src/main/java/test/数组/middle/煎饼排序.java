package test.数组.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2019-07-15.
 */
public class 煎饼排序 {


    public static void main(String[] args) {

        int[] A = {3, 2, 4, 1};

        //3, 4, 2, 3, 1, 2, 1, 1
        /**
         *  大概的过程
         * {4,2,3,1}
         * {1,3,2,4}
         * {3,1,2,4}
         * {2,1,3,4}
         *
         */

        List<Integer> result = pancakeSort(A);
        System.out.println(result);

    }

    public static List<Integer> pancakeSort(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int index = 0;
            //寻找最大的index
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            //找到最大值的index, 这一步的reverse直接将最大值,送到第一位
            reverse(array, index + 1);
            //既然上面的步骤, 是将最大值放到第一位, 那么我们直接将第一位的值,放到最后一位就好了
            // 因为数组 在不断的变小 所以最后一位的index 也在不断的变小
            reverse(array, array.length - i);
            //然后将index+1也就是代表要移动多少哥元素的值 add到result
            result.add(index + 1);
            result.add(array.length - i);
        }

        return result;
    }


    private static void reverse(int[] A, int maxIndex) {
        for (int j = 0; j < maxIndex / 2; j++) {
            swap(A, j, maxIndex);
        }
    }

    private static void swap(int[] A, int start, int end) {
        int tmp = A[start];
        A[start] = A[end - start - 1];
        A[end - start - 1] = tmp;
    }


}
