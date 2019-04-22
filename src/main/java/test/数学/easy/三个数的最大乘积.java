package test.数学.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/25.
 */
public class 三个数的最大乘积 {

    /**
     * [174,-524,-624,903,982,-219,126,876,-875,-617,-495,-621,194,-333,804,-199,-916,-88,-706,562,-293,-876,-697,975,-6,197,544,-919,-487,432,-849,512,619,44,252,-388,-177,-256,-847,-206,114,116,-827,518,-511,-511,257,-630,56,706,675,-705,-211,170,-13,684,836,-708,336,728,511,-229,-403,310,206,539,784,666,506,-252,-34,709,233,-290,633,29,-550,-412,-778,-107,-123,724,-58,-97,71,776,104,207,-381,-132,88,312,-39,478,-817,-484,-929,651,434,-911]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{174, -524, -624, 903, 982, -219, 126, 876, -875, -617, -495, -621, 194, -333, 804, -199, -916, -88, -706, 562, -293, -876, -697, 975, -6, 197, 544, -919, -487, 432, -849, 512, 619, 44, 252, -388, -177, -256, -847, -206, 114, 116, -827, 518, -511, -511, 257, -630, 56, 706, 675, -705, -211, 170, -13, 684, 836, -708, 336, 728, 511, -229, -403, 310, 206, 539, 784, 666, 506, -252, -34, 709, 233, -290, 633, 29, -550, -412, -778, -107, -123, 724, -58, -97, 71, 776, 104, 207, -381, -132, 88, 312, -39, 478, -817, -484, -929, 651, 434, -911};
        System.out.println(maximumProduct(array));
    }


//    public static int maximumProduct(int[] nums) {
//        Arrays.sort(nums);
//        //One of the Three Numbers is the maximum value in the array.
//
//        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
//        int b = nums[0] * nums[1] * nums[nums.length - 1];
//        return a > b ? a : b;
//    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        //都是负数的情况下
        int max = 0;
        if (nums[0] < 0 && nums[nums.length - 1] >= 0) {
            int num1 = nums[nums.length - 1];
            int num2 = (nums[0] * nums[1])
                    > (nums[nums.length - 2] * nums[nums.length - 3]) ? (nums[0] * nums[1])
                    : (nums[nums.length - 2] * nums[nums.length - 3]);
            max = num1 * num2;
        } else {
            max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
        return max;
    }
}
