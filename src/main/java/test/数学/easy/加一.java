package test.数学.easy;


/**
 * Created by mengyue on 2018/8/25.
 */
public class 加一 {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int carry = 1;
        while (index >= 0 && carry > 0) {
            int sum = carry + digits[index];
            digits[index] = sum % 10;
            carry = sum / 10;
            index--;
        }
        if (carry > 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = carry;
            for (int i = 1; i < newArray.length; i++) {
                newArray[i] = digits[i - 1];
            }
            return newArray;
        }
        return digits;
    }

}
