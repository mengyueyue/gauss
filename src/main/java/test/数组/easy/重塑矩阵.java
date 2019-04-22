package test.数组.easy;

/**
 * Created by mengyue on 2018/7/30.
 */
public class 重塑矩阵 {

    public static void main(String[] args) {

    }

//    public int[][] matrixReshape(int[][] nums, int r, int c) {
//        int n = nums.length, m = nums[0].length;
//        if (r*c != n*m) return nums;
//        int[][] res = new int[r][c];
//        for (int i=0;i<r*c;i++)
//            res[i/c][i%c] = nums[i/m][i%m];
//        return res;
//    }


    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] newNums = new int[r][c];
        int[] array = new int[r * c];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                array[index] = nums[i][j];
                index++;
            }
        }
        index = 0;
        for (int i = 0; i < newNums.length; i++) {
            for (int j = 0; j < newNums[0].length; j++) {
                newNums[i][j] = array[index];
                index++;
            }
        }
        return newNums;
    }
}
