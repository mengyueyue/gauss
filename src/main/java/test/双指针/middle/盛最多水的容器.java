package test.双指针.middle;

/**
 * Created by mengyue on 2019-05-10.
 */
public class 盛最多水的容器 {


    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {

        int max = 0;

        for (int i = 0, j = height.length - 1; i < j; ) {

            int minHeight = height[i] < height[j] ? height[i++] : height[j--];

            max = Math.max(max, (j - i + 1) * minHeight);

        }

        return max;
    }
}
