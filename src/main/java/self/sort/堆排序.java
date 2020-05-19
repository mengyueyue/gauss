package self.sort;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-06-26.
 */
public class 堆排序 {

    /**
     * https://yq.aliyun.com/articles/681640
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] array = new int[]{235, 123, 12, 5, 7, 14, 23, 124, 1, 6};
        //forwardScanSort(array, 0, array.length - 1);
        heapSort(array);
        //QuickSort3Way(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    /**
     * 因为数组是从下标0开始的 所以
     * parent * 2 + 1 = left child
     * parent * 2 + 2 = right child
     * <p>
     * 第一个非叶子节点的index = （length / 2) - 1
     * <p>
     * 如果数的第一个节点的开始下标为1
     * parent * 2 = left child
     * parent * 2 + 1 = right child
     * <p>
     * 第一个非叶子节点的index = ()
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

        /**
         *
         * arr.length / 2 - 1 其实得出得结果是 第一个非叶子节点得index
         *
         */
        /**
         *
         * 这里的 i = arr.length / 2 - 1 找到了第一个非叶子节点
         * 然后for循环 i--, 是因为小于第一个非叶子节点的index 都是非叶子节点,
         * 这些节点都至少有一个child 所以都需要比较排序
         * for 循环比较完成后 我们就得到了一个大堆 或者是小堆
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
        /**
         *
         *  j = i * 2 + 1 的意思就是 找i的left child
         *
         *  j < length 判断是否有出界 这里为什么是小于呢 因为 j的最大值是length - 1 当然这里也可以写成 j<= length -1
         *
         *  j = j * 2 + 1 是为了循环的判断节点 j 的子树们 // 其实这一步是为了从index = 0 开始判断准备的吧
         */
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            /**
             * 因为这里的j是parent的左孩子
             * j + 1 < length 是判断是否还有右孩子(也是为了 防止出现数组下标越界的情况)
             *
             * arr[j] < arr[j + 1] 这个判断是为了
             * 假设在有右孩子的情况下 比较这两个孩子的大小如果右孩子(arr[j+1]) 大于 左孩子(arr[j])的话
             *
             * j++的话 就是根据上面的比较 判断child中最值是否应该指向右孩子 指向右孩子的话j++ 指向左孩子的话 那还是j本身
             *
             */
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            //因为这里是在构造大堆 所以发现child <= parent的情况 就要终止
            if (arr[j] <= arr[i]) {
                break;
            }
            //如果 child > parent 的情况的话 我们就需要交换 并且交换的j这个位置的顺序被打乱 需要从j这个节点开始 重新比较排序
            //这里的j可能是左孩子 也有可能是右孩子
            swap(arr, i, j);
            i = j;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
