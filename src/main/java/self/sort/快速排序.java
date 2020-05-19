package self.sort;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/1.
 */
public class 快速排序 {


    public static void main(String[] args) {
        int[] array1 = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        int[] array2 = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        int[] array3 = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        int[] array4 = new int[]{23, 123, 12, 5, 7, 14, 235, 124, 1, 6};
        forwardScanSort(array1, 0, array1.length - 1);
        deScanSwapSort(array2, 0, array2.length - 1);
        dualPivotQuickSort(array3, 0, array3.length - 1);
        QuickSort3Way(array4, 0, array4.length - 1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
    }

    //双向扫描方式
    public static void deScanSwapSort(int[] items, int start, int end) {
        if (start < end) {
            int pivot = items[start];

            int i = start + 1, j = end;
            while (i <= j) {
                while (i <= j && items[i] < pivot)
                    i++;
                while (i <= j && items[j] >= pivot)
                    j--;
                if (i <= j) {
                    swap(items, i, j);
                }
            }
            // 将中心点交换到中间。
            swap(items, start, j);
            // 中心点左半部分递归
            deScanSwapSort(items, start, j - 1);
            // 中心点右半部分递归
            deScanSwapSort(items, j + 1, end);
        }
    }

    private static void swap(int[] items, int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //单项扫描方式
    public static void forwardScanSort(int[] items, int start, int end) {
        if (start < end) {
            int pivot = items[start], i = start, j = start + 1;
            while (j <= end) {
                if (items[j] < pivot) {
                    //先i++ 这样就会保持pivot一直是items[start]的值 直到start和i交换的时候
                    i++;
                    swap(items, i, j);
                }
                j++;
            }
            swap(items, start, i);
            forwardScanSort(items, start, i - 1);
            forwardScanSort(items, i + 1, end);
        }
    }


    public static void QuickSort3Way(int[] A, int L, int R) {
        if (L >= R) {//递归终止条件，少于等于一个元素的数组已有序
            return;
        }

        int i, j, k, pivot;
        pivot = A[L]; //首元素作为中轴
        i = L;
        k = L + 1;
        j = R;

        OUT_LOOP:
        while (k <= j) {
            if (A[k] < pivot) {
                swap(A, i, k);
                i++;
                k++;
            }
            if (A[k] == pivot) {
                k++;
            } else {// 遇到A[k]>pivot的情况，j从右向左扫描
                while (A[j] > pivot) {//A[j]>pivot的情况,j继续向左扫描
                    j--;
                    if (j < k) {
                        break OUT_LOOP;
                    }
                }
                if (A[j] == pivot) {//A[j]==pivot的情况
                    swap(A, k, j);
                    k++;
                    j--;
                } else {//A[j]<pivot的情况
                    swap(A, i, j);
                    swap(A, j, k);
                    i++;
                    k++;
                    j--;
                }
            }
        }
        //A[i, j] 等于 pivot 且位置固定，不需要参与排序
        QuickSort3Way(A, L, i - 1); // 对小于pivot的部分进行递归
        QuickSort3Way(A, j + 1, R); // 对大于pivot的部分进行递归
    }


    public static void dualPivotQuickSort(int[] items, int start, int end) {
        if (start < end) {
            if (items[start] > items[end]) {
                swap(items, start, end);
            }
            int pivot1 = items[start], pivot2 = items[end];
            int i = start, j = end, k = start + 1;
            OUT_LOOP:
            while (k < j) {
                if (items[k] < pivot1) {
                    swap(items, ++i, k++);
                } else if (items[k] <= pivot2) {
                    k++;
                } else {// 其实就是 items[k] > pivot2的
                    while (items[--j] > pivot2) {
                        if (j <= k) {
                            // 扫描终止
                            break OUT_LOOP;
                        }
                    }

                    if (items[j] < pivot1) {
                        swap(items, j, k);
                        swap(items, ++i, k);
                    } else { // 间于 pivot1<=x<=pivot2的
                        swap(items, j, k);
                    }
                    k++;
                }
            }
            swap(items, start, i);
            swap(items, end, j);

            dualPivotQuickSort(items, start, i - 1);
            dualPivotQuickSort(items, i + 1, j - 1);
            dualPivotQuickSort(items, j + 1, end);
        }
    }

}
