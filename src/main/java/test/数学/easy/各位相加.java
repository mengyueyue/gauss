package test.数学.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 各位相加 {


    public static void main(String[] args) {

        System.out.println(addDigits(38));
    }


    public static int addDigits(int num) {
        String s = String.valueOf(num);
        if (s.length() != 1) {
            int length = s.length();
            int total = 0;
            for (int i = 0; i < length; i++) {
                total += Integer.valueOf(String.valueOf(s.charAt(i)));
            }
            return addDigits(total);
        }
        return num;
    }

}
