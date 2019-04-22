package test.数组.easy;

/**
 * Created by mengyue on 2018/8/19.
 */
public class 托普利茨矩阵 {


    public static void main(String[] args) {

//        int[][] matrix = new int[2][2];
//        matrix[0][0] = 1;
//        matrix[0][1] = 2;
//        matrix[1][0] = 2;
//        matrix[1][1] = 2;
//        System.out.println(isToeplitzMatrix(matrix));
    }


//    public static boolean isToeplitzMatrix(int[][] matrix) {
//        boolean result = true;
//        int iong = matrix.length;
//        int width = matrix[0].length;
//        int x = 0, y = 0;
//        for (int i = 0; i < iong; i++) {
//            x = i;
//            result = judge(x, y, matrix, false);
//            if (result == false) {
//                return false;
//            }
//        }
//        for (int j = 1; j < width; j++) {
//            y = j;
//            result = judge(x, y, matrix, true);
//            if (result == false) {
//                return false;
//            }
//        }
//        return result;
//    }
//
//    public static boolean judge(int x, int y, int[][] matrix, boolean tag) {
//        int a = matrix[x][y];
//        int first = x + 1;
//        int second = y + 1;
//        int b = Integer.MIN_VALUE;
//        if (tag) {
//            int temp = first;
//            first = second;
//            second = temp;
//        }
//        if (first < matrix.length && second < matrix[0].length) {
//            b = matrix[first][second];
//        }
//        if (b != Integer.MIN_VALUE && a != b) {
//            return false;
//        }
//        return true;
//    }
}
