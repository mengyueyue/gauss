package test.数组.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/11/21.
 */
public class 数组中重复的数据 {


    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDuplicates(nums);
        System.out.println(result.toString());

    }


    //我无话可说 牛逼！！！！！！！！！！！！！！1

    /**
     * 将原来的值的设置为负数 来表示数组中 存在下标为index的数据 以后数据再设置的时候 发现index位置为负数了
     * 那么这个数就是重复的数据了 可以将其 加入到list中
     */

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }


}
