package test.数组.easy;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 两数之和II输入有序数组 {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度为 O(nlogn) 空间为 O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
