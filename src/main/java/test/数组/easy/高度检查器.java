package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-07-19.
 */
public class 高度检查器 {

    public static void main(String[] args) {

        int[] heights = {1, 1, 4, 2, 1, 3};

        System.out.println(heightChecker(heights));

    }

    public static int heightChecker(int[] heights) {

        int count = 0;
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i]) count++;
        }

        return count;
    }
}
