package test.数组.middle;

/**
 * Created by mengyue on 2018/11/21.
 */
public class 寻找重复数 {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 4, 2, 2};
        //int[] nums = new int[]{1, 1};
        System.out.println(findDuplicate(nums));
    }

    // 自己拙劣的想法
//    public static int findDuplicate(int[] nums) {
//
//        int re = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//            while (true) {
//                int num = nums[i];
//                if (i == nums[i] - 1) {
//                    break;
//                }
//                if (num == nums[num - 1]) {
//                    re = num;
//                    break;
//                }
//                switchRecord(i, num - 1, nums);
//            }
//            if (re != Integer.MIN_VALUE) {
//                break;
//            }
//        }
//        return re;
//    }
//
//
//    public static void switchRecord(int i, int j, int[] nums) {
//        nums[i] = nums[i] ^ nums[j];
//        nums[j] = nums[i] ^ nums[j];
//        nums[i] = nums[i] ^ nums[j];
//
//    }


    public static int findDuplicate(int[] nums) {
        if (nums.length < 2) return 0;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
