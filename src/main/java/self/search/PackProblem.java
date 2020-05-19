package self.search;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/2.
 */
public class PackProblem {

    public static void main(String[] args) {

        int[] value = new int[]{3, 4, 5, 6};
        int[] weight = new int[]{2, 3, 4, 5};
        int w = 8;
        System.out.println(Arrays.deepToString(knapsack01(value, weight, w)));
        //System.out.println(knapsack(value, weight, w));
    }

    //http://www.importnew.com/13072.html
    //https://www.cnblogs.com/Christal-R/p/Dynamic_programming.html
    public static int[][] knapsack01(int value[], int weight[], int w) {

        int[][] table = new int[value.length + 1][w + 1];
        for (int i = 0; i < w + 1; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i < value.length + 1; i++) {
            table[i][0] = 0;
        }

        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= w; j++) {
                //int result = i -1;
                if (j < weight[i - 1]) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(value[i - 1] + table[i - 1][j - weight[i-1]], table[i - 1][j]);
                }
            }
        }
        return table;
    }


    //01背包问题
//    public static int[][] knapsack01(int val[], int wt[], int W) {
//
//        int[][] array = new int[val.length + 1][W + 1];
//
//        for (int i = 0; i <= val.length; i++) {
//            array[i][0] = 0;
//        }
//        for (int i = 0; i <= W; i++) {
//            array[0][i] = 0;
//        }
//
//        for (int item = 1; item <= val.length; item++) {
//            for (int weight = 1; weight <= W; weight++) {
//                int result = item - 1;
//                if (wt[result] <= weight) {
//                    int v1 = val[result] + array[result][weight - wt[result]];
//                    int v2 = array[result][weight];
//                    array[item][weight] = Math.max(v1, v2);
//                } else {
//                    array[item][weight] = array[result][weight];
//                }
//            }
//        }
//        return array;
//    }


    public static int knapsack(int val[], int wt[], int W) {
        //Get the total number of items.
        //Could be wt.length or val.length. Doesn't matter
        int N = wt.length;

        //Create a matrix.
        //Items are in rows and weight at in columns +1 on each side
        int[][] V = new int[N + 1][W + 1];

        //What if the knapsack's capacity is 0 - Set
        //all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }

        //What if there are no items at home.
        //Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }

        for (int item = 1; item <= N; item++) {
            //Let's fill the values row by row
            for (int weight = 1; weight <= W; weight++) {
                //Is the current items weight less
                //than or equal to running weight
                if (wt[item - 1] <= weight) {
                    V[item][weight] = Math.max(val[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                } else {
                    V[item][weight] = V[item - 1][weight];
                }
            }
        }

        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }

        return V[N][W];
    }
}
