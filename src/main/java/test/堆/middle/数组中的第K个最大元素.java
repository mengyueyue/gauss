package test.堆.middle;

/**
 * Created by mengyue on 2018/11/6.
 */
public class 数组中的第K个最大元素 {


    public static void main(String[] args) {

        int [] arr = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }


    public static int findKthLargest(int[] nums, int k) {

        int start = 0;
        int end = nums.length - 1;
        k = end - k + 1;
        while (start < end) {
            int middle = partation(nums, start, end);
            if (middle > k) {
                end = middle - 1;
            } else if (middle < k) {
                start = middle + 1;
            } else {
                break;
            }

        }
        return nums[k];
    }


    private static int partation(int[] num, int start, int end) {

        int i = start;
        int j = end + 1;
        while (true) {
            while (i < end && num[++i] < num[start]) ;
            while (j > start && num[start] < num[--j]) ;
            if (i >= j) {
                break;
            }
            exchange(num, i, j);
        }
        exchange(num, start, j);
        return j;
    }

    private static void exchange(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
