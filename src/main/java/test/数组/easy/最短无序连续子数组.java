package test.数组.easy;

/**
 * Created by mengyue on 2018/9/18.
 */
//todo reeview
public class 最短无序连续子数组 {


    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 2, 4, 5, 6};
        System.out.println(findUnsortedSubarray(a));
    }


    public static int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);
            if (A[i] < max) end = i;
            if (A[n - 1 - i] > min) beg = n - 1 - i;
        }
        return end - beg + 1;
    }
}
