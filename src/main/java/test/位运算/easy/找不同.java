package test.位运算.easy;

/**
 * Created by mengyue on 2019-05-21.
 */
public class 找不同 {

    public static void main(String[] args) {

    }


//    public static char findTheDifference(String s, String t) {
//
//        int[] b = new int[26];
//
//        for (char c : s.toCharArray()) {
//            int offset = c - 'a';
//            b[offset]++;
//        }
//        for (char c : t.toCharArray()) {
//            int offset = c - 'a';
//            b[offset]--;
//            if (b[offset] == -1) {
//                return c;
//            }
//        }
//
//        return 'a';
//    }


    /**
     * 异或的方式
     */
    public static char findTheDifference(String s, String t) {

        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }

        return result ^= t.charAt(t.length() - 1);
    }

}
