package test.动态规划.easy;

import org.omg.CORBA.INTERNAL;

/**
 * Created by mengyue on 2018/8/21.
 */
public class 求所有的组合 {


    public static void main(String[] args) {

        int[] array = new int[]{10, 15, 20, 30, 40};
        getResult(array, 50);
    }


    public static void getResult(int[] array, int num) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (num == array[i] + array[j]) {
                    System.out.println("组合：" + array[i] + array[j]);
                }
            }
        }
    }
}
