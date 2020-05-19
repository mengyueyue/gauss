package self.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-11-26.
 */
public class 冒泡排序 {


    @Test
    public void sort() {

        int[] nums = {1, 23, 54, 9, 3, 46, 6, 789, 12, 34};

        int boundary = nums.length;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < boundary; j++) {

                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }

            }

            boundary--;

        }

        System.out.println(Arrays.toString(nums));

    }
}
