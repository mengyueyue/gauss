package test.滑动窗口.middle;

/**
 * Created by mengyue on 2019-10-21.
 */
public class 最大连续1的个数III_1004 {

    public static void main(String[] args) {

    }


    public static int longestOnes(int[] nums, int k) {
        int res = 0, zero = 0, left = 0;
        for (int right = 0; right < nums.length; ++right) {
            /**
             *
             * 这里的判断 相当于开始先任由right 向右移动 因为只要zero的个数小于等于K 我们都可以给他翻转过来
             *
             * 直到zero的个数大于k的个数 我们开始移动left指针 left指针向右移动 窗口缩小
             *
             * 但我们还会判断一下 在left走过的路程上 如果遇到的value是非0的 那么count zero的数量不减少 value是0 减少count zero的数量
             *
             */
            if (nums[right] == 0) ++zero;
            while (zero > k) {
                if (nums[left++] == 0) --zero;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }


//    public static int longestOnes(int[] A, int K) {
//        int start = 0;
//        int end = 0;
//        while (end < A.length) {
//            K -= 1 - A[end++];
//            if (K < 0) {
//                K += 1 - A[start++];
//            }
//        }
//        return end - start;
//    }

}
