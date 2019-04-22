package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/22.
 */
public class 按奇偶校验排序数组 {


    public static void main(String[] args) {

        int[] array = new int[]{3, 1};
        System.out.println(Arrays.toString(sortArrayByParity(array)));
    }


    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 1) {
            return A;
        }
        int i = 0, j = A.length - 1;
        while (i <= j) {
            if (isOdd(A[i])) {
                //赋给j的位置
                while (isOdd(A[j]) && j > i) {
                    j--;
                }
                swap(i, j, A);
                j--;
            }
            i++;
        }
        return A;
    }

    private static void swap(int i, int j, int[] A) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    //奇数
    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
