package test.数学.easy;

/**
 * Created by mengyue on 2018/9/19.
 */
public class x的平方根 {


    public static void main(String[] args) {
        int a = 8;
        System.out.println(mySqrt(a));
    }


    public static int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x, ans =0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
