package test.数组.middle;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/23.
 */
public class 旋转图像 {


    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int[] c1 = new int[]{1, 2, 3};
        int[] c2 = new int[]{4, 5, 6};
        int[] c3 = new int[]{7, 8, 9};
        matrix[0] = c1;
        matrix[1] = c2;
        matrix[2] = c3;
        rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }

    public static void rotate(int[][] matrix) {


    }
}
