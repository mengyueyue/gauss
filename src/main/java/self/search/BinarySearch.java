package self.search;

/**
 * Created by mengyue on 2018/8/11.
 */
public class BinarySearch {// todo done

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array, 9));
    }

    /**
     * 二分查找的特点是：
     * 1。数组必须是有序的
     * 2。时间复杂度是： O(log2n)
     *
     * @param array
     * @param key
     * @return
     */

    public static int binarySearch(int[] array, int key) {

        int low = 0, high = array.length - 1, mid = 0;

        /**
         * low <= high 为了能让循环有跳出的条件，如果写成true的话，只能在数组内有这个key时才会跳出，否则就是死循环了
         */
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == key)
                return mid;
            if (array[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

}
