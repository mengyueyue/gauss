package self.sort;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-06-25.
 */
public class 希尔排序 {


    public static void main(String[] args) {


        int[] array = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        shellSort(array);
        System.out.println(Arrays.toString(array));

    }


    public static void shellSort(int[] arr) {

        int length = arr.length;
        int j = 0;
        int step = length / 2;
        int temp = 0;

        while (step > 0) {
            for (int i = step; i < length; i++) {
                //arr[i] 是更小一点的数
                if (arr[i] < arr[i - step]) {
                    //将小一点的数 保存起来
                    temp = arr[i];
                    j = i - step;
                    //在向前走的过程中 发现j这个位置的数 大于temp 符合将j位置的数往后放的条件
                    while (j >= 0 && arr[j] > temp) {
                        //将j位置的数 往后放到j+step位置
                        arr[j + step] = arr[j];
                        //index 继续向前走
                        j -= step;
                    }
                    arr[j + step] = temp;
                }

            }
            step /= 2;
        }
    }


}
