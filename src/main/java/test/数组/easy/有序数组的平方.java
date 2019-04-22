package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2019/2/12.
 */
public class 有序数组的平方 {


    public static void main(String[] args) {


        int[] A = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(sortedSquares(A)));

    }

    // 时间空间都是O(N)
    private static int[] sortedSquares(int[] A) {

        int a = 0, b = A.length - 1;

        int[] result = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {

            if (Math.abs(A[a]) > Math.abs(A[b])) {
                result[i] = A[a] * A[a];
                a++;
            } else {
                result[i] = A[b] * A[b];
                b--;
            }

        }

        return result;
    }

}
