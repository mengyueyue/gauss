package test.数学.easy;

/**
 * Created by mengyue on 2018/8/25.
 */
public class 字符串相加 {

    public static void main(String[] args) {

        String a = "35";
        String b = "5";
        System.out.println(addStrings(a, b));
    }

    public static String addStrings(String num1, String num2) {
        String s = "";
        char[] aChars = num1.toCharArray();
        char[] bChars = num2.toCharArray();
        int aLength = aChars.length - 1;
        int bLength = bChars.length - 1;
        int carry = 0;
        while (aLength >= 0 || bLength >= 0) {
            char aValue = '0';
            char bValue = '0';
            if (aLength >= 0) {
                aValue = aChars[aLength];
                aLength--;
            }
            if (bLength >= 0) {
                bValue = bChars[bLength];
                bLength--;
            }
            int total = charAddChar(aValue, bValue, carry);
            carry = total / 10;
            int curr = total % 10;
            s = curr + s;
        }
        if (carry > 0) {
            s = carry + s;
        }
        return s;
    }

    public static int charAddChar(char c1, char c2, int carry) {
        return c1 + c2 - 2 * '0' + carry;
    }
}
