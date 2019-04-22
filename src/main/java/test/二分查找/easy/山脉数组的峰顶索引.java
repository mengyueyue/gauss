package test.二分查找.easy;

/**
 * Created by mengyue on 2018/9/26.
 */
public class 山脉数组的峰顶索引 {


    /**
     * 我们把符合下列属性的数组 A 称作山脉：
     * <p>
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[0,1,0]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：[0,2,1,0]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= A.length <= 10000
     * 0 <= A[i] <= 10^6
     * A 是如上定义的山脉
     *
     * @param args
     */

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 1};
        //int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 9, 8, 7, 6, 5, 4};

        System.out.println(peakIndexInMountainArray(a));
    }


//    public static int peakIndexInMountainArray(int[] A) {
//
//        int index = 0, max = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (max < A[i]) {
//                max = A[i];
//                index = i;
//            }
//        }
//        return index;
//    }

    public static int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (A[mid] < A[mid + 1]) l = mid;
            else if (A[mid - 1] > A[mid]) r = mid;
            else return mid;
        }
        return 0;
    }
}
