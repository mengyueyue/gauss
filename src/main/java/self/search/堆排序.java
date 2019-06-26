package self.search;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-06-26.
 */
public class 堆排序 {

    public static void main(String[] args) {


        int[] array = new int[]{235, 123, 12, 5, 7, 14, 23, 124, 1, 6};
        //forwardScanSort(array, 0, array.length - 1);
        heapSort(array);
        //QuickSort3Way(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }


    public static void heapSort(int[] arr) {

        /**
         *
         * arr.length / 2 - 1 其实得出得结果是 第一个非叶子节点得index
         *
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            //是因为整体是有序的 除了第一个元素外 所以 只要排序第一个元素就可以了
            adjustHeap(arr, 0, j);
        }

    }

    public static void adjustHeap(int[] arr, int i, int length) {


        int temp = arr[i];

        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {

            //判断是否还有有节点 有得话 并且有节点得值 大于 左节点得值
            //将index ++ 也就是 将指向最大值得index指向右节点
            //如果有子节点大于父节点的情况 和父节点做完 交换之后 j会变到这个子节点的左右子节点上 和 它去比较大小
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            //判断子节点 和 父节点的值的大小 如果大于的话 将这个值 直接覆盖父节点的值 以及index ，temp有保留父节点的值 i也有存大的子节点的index
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }

        }

        arr[i] = temp;//最终将将交换得值 放到这里


    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
