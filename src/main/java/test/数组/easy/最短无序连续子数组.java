package test.数组.easy;

/**
 * Created by mengyue on 2018/9/18.
 */
//todo review
public class 最短无序连续子数组 {


    public static void main(String[] args) {
        //int[] a = new int[]{1, 3, 5, 7, 2, 4, 5, 6};
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(findUnsortedSubarray(a));
    }

    /**
     * 条件分析：
     * <p>
     * 1. beg 和 end 设计成 -1  , -2 的目的是 为了 在边界条件 1，2，3，4，5的情况下 ，这种情况下，两个if条件都是不成立的，所以 beg 和 end
     * 的值都是一直不变的 所以在最后 才能  -1 + -2 + 1 =0 得到正确的结果 0
     * 2. 而 在条件为 5，4，3，2，1的边界条件下 return 的结果为 end - beg + 1 => (i) + (n- 1 -i) + (1) => n => A.length
     *
     * @param A
     * @return
     */
    public static int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
        for (int i = 1; i < n; i++) {
            //这里会把12，13 这种条件下的 A[i]赋值给max,也就是 原本max = 12 ; max = Math.max(12,13)
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);

            // 那种 顺序为 15,14,X,Y 的条件中招
            if (A[i] < max) end = i;
            // 那种 顺序为 12,13,X,Y 的条件中招
            if (A[n - 1 - i] > min) beg = n - 1 - i;
        }
        return end - beg + 1;
    }



//    public int findUnsortedSubarray(int[] nums) {
//        int n = nums.length;
//        int beg = -1;
//        int end = -2;
//        int max = nums[0];
//        int min = nums[n-1];
//
//        for(int i = 1 ; i < nums.length ;i++){
//            // 中招的是 14，15 的情况 这种情况是有意义的 1
//
//            // 没有意义的 是 15， 14的情况
//            max = Math.max(max , nums[i]);
//            min = Math.min(min , nums[n-1-i]);
//
//            // 中招的是 15，14 的情况 指针向后移动
//            if(max > nums[i]){
//                end = i ;
//            }else{
//                // 情况1 ： 14， 15 是正常的升序 所以 指针不做任何的移动
//            }
//            if(min < nums[n-1-i]){
//                beg = n -1-i;
//            }
//
//        }
//
//        return end - beg + 1;
//    }
}
