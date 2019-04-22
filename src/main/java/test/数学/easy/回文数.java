package test.数学.easy;

/**
 * Created by mengyue on 2018/8/20.
 */
public class 回文数 {


    public static void main(String[] args) {

        System.out.println(isPalindrome(10));

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
