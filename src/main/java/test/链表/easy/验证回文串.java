package test.链表.easy;

/**
 * Created by mengyue on 2018/9/19.
 */
public class 验证回文串 {


    public static void main(String[] args) {

        String s = "0P";
        System.out.println(isPalindrome(s));
    }

//    public static boolean isPalindrome(String s) {
//        if (s.isEmpty()) {
//            return true;
//        }
//        int head = 0, tail = s.length() - 1;
//        char cHead, cTail;
//        while(head <= tail) {
//            cHead = s.charAt(head);
//            cTail = s.charAt(tail);
//            if (!Character.isLetterOrDigit(cHead)) {
//                head++;
//            } else if(!Character.isLetterOrDigit(cTail)) {
//                tail--;
//            } else {
//                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
//                    return false;
//                }
//                head++;
//                tail--;
//            }
//        }
//
//        return true;
//    }


    public static boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            char a = low(array[start]);
            char b = low(array[end]);
            if (!isValid(a)) {
                start++;
                continue;
            }
            if (!isValid(b)) {
                end--;
                continue;
            }
            if (Math.abs(a - b) != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isValid(char c) {
        return ('a' <= c && 'z' >= c) || ('0' <= c && '9' >= c);
    }

    public static char low(char c) {
        if ('A' <= c && 'Z' >= c) {
            return (char) ('a' - 'A' + c);
        }
        return c;
    }
}
