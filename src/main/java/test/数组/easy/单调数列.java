package test.数组.easy;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 单调数列 {

    public static void main(String[] args) {

    }

    public boolean isMonotonic(int[] A) {
        //单增
        if (A[0] <= A[A.length - 1]) {
            int m = 0;
            for (int i = 0; i < A.length - 1; i++) {
                m = A[i + 1] - A[i];
                if (m < 0) {
                    return false;
                }
            }
        }
        if (A[0] >= A[A.length - 1]) {
            int m = 0;
            for (int i = 0; i < A.length - 1; i++) {
                m = A[i + 1] - A[i];
                if (m > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
