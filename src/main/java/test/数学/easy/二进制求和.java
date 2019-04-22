package test.数学.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 二进制求和 {


    public static void main(String[] args) {

        System.out.println(addBinary("1", "111"));

    }


    public static String addBinary(String a, String b) {
        int diff = a.length() - b.length() > 0 ? a.length() - b.length() : b.length() - a.length();
        if (a.length() > b.length()) {
            for (int i = 0; i < diff; i++) {
                b = "0" + b;
            }
        }
        if (a.length() < b.length()) {
            for (int i = 0; i < diff; i++) {
                a = "0" + a;
            }
        }
        String result = "";
        int carry = 0;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = a.length() -1; i >= 0; i--) {
            int aa = char2Int(aChars[i]);
            int bb = char2Int(bChars[i]);
            if (aa + bb + carry > 1) {
                result = (aa + bb + carry -2) + result;
                carry = 1;
            } else {
                result = aa + bb + carry + result;
                carry = 0;
            }
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }

    public static Integer char2Int(char c) {
        return Integer.valueOf(String.valueOf(c));
    }


}
