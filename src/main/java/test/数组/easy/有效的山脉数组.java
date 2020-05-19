package test.数组.easy;

/**
 * Created by mengyue on 2019-07-16.
 */
public class 有效的山脉数组 {


    public static void main(String[] args) {


    }


    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        // 峰值索引
        int index = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i]) {
                index = i;
            } else {
                break;
            }
        }
        if (index == 0) {
            return false;
        }
        for (int i = index; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
