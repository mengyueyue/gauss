package self.search;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-06-25.
 */
public class 插入排序 {


    public static void main(String[] args) {

        //int[] array = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        int[] array = new int[]{5, 1};
        int[] array2 = new int[]{0, 23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        straightInsertSort(array);
        straightInsertSort2(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));

    }

    /**
     *
     * 插入排序是在无序序列中选出一个元素 和有序序列从右像左比较
     *
     * @param arr
     */
    public static void straightInsertSort(int[] arr) {

        int tmp = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                tmp = arr[i];
                //发现更小的数 需要将此数方到前面
                for (j = i - 1; j >= 0 && tmp < arr[j]; --j) {
                    arr[j + 1] = arr[j];// 不用担心j位置的将j+1位置的数给覆盖掉 因为tmp = arr[i] 已经将空间给腾了出来
                }
                //上面将j减一了所以 这里要j+1了
                arr[j + 1] = tmp;
            }
        }

    }

    /**
     * 哨兵模式下的第一数 是没有用的数（必须的）
     *
     * @param arr
     */
    public static void straightInsertSort2(int[] arr) {
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            System.out.println("arr[0]==" + arr[0]);
            // 后一个小于前一个
            if (arr[i] < arr[i - 1]) {
                arr[0] = arr[i];
                int j;
                //将arr[0] 插入到 0～j之间的位置
                for (j = i - 1; arr[0] < arr[j]; --j) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = arr[0];
            }
        }
    }


}
