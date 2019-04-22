package test.easy;

/**
 * Created by mengyue on 2018/7/26.
 */
public class 山脉数组的峰顶索引 {


    /**
     *
     *
     *
     * 这题其实就是求最大值
     *
     *

     我们把符合下列属性的数组 A 称作山脉：

     A.length >= 3
     存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。



     示例 1：

     输入：[0,1,0]
     输出：1
     示例 2：

     输入：[0,2,1,0]
     输出：1


     提示：

     3 <= A.length <= 10000
     0 <= A[i] <= 10^6
     A 是如上定义的山脉

     *
     *
     *
     *
     * @param args
     */



    public static void main(String[] args) {

        int A[] = new int[]{0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(A));
    }


    public static int peakIndexInMountainArray(int[] A) {
        int temp = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                temp = i;
                break;
            }
        }
        return temp;
    }


}
