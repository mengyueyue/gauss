package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-05-13.
 */
public class 按奇偶排序数组II {


    public static void main(String[] args) {

        int[] A = {4, 2, 5, 7};

        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }


    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * <p>
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * <p>
     * 你可以返回任何满足上述条件的数组作为答案。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     */
    public static int[] sortArrayByParityII(int[] A) {

        int[] B = new int[A.length];

        int o = 0;

        int j = 1;

        for (int i = 0; i < A.length; i++) {
            //偶数
            if ((A[i] & 1) == 0) {
                B[o] = A[i];
                o += 2;
            } else {
                B[j] = A[i];
                j += 2;

            }

        }

        return B;
    }
}
