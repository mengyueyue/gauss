package test.滑动窗口.middle;

/**
 * Created by mengyue on 2019-10-22.
 */
public class 最大连续1的个数II_487 {


    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,0,1,1,0]
     * Output: 4
     * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     * After flipping, the maximum number of consecutive 1s is 4.
     * <p>
     * <p>
     * Note:
     * <p>
     * The input array will only contain 0 and 1.
     * The length of input array is a positive integer and will not exceed 10,000
     * <p>
     * <p>
     * Follow up:
     * What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] nums = {0, 1, 0, 0};

        System.out.println(findMaxConsecutiveOnes(nums));


    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int res = 0, cur = 0, cnt = 0;
        for (int num : nums) {
            ++cnt;
            /**
             * num 等于0的时候 就用当前的count数 覆盖current_count  并且将count设置为0
             * 如果后续的数 是1的话 那么就走count增加的逻辑 并且判断Math.max(res, cnt + cur)
             * 否则后续的数 是0的话 那么就将cur覆盖用cnt的值 其实也就是1 并且cnt的值设置为 0 并且判断Math.max(res, cnt + cur)
             *
             */
            if (num == 0) {
                cur = cnt;
                cnt = 0;
            }
            res = Math.max(res, cnt + cur);
        }
        return res;

    }


}
