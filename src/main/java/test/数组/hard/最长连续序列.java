package test.数组.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2018/8/26.
 */
public class 最长连续序列 {

    public static void main(String[] args) {

        int[] array = new int[]{1,23, 421, 3, 1235, 7, 912, 367, 24, 157, 2, 1};
        longestConsecutive(array);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
