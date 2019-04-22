package test.数学.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class Excel表列序号 {


    public static void main(String[] args) {

        System.out.println(titleToNumber("AA"));
    }


    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int total = 0;
        int first = getNumber(chars[chars.length - 1]);
        int index = 1;
        for (int i = chars.length - 2; i >= 0; i--, index++) {
            total += getNumber(chars[i]) * Math.pow(26, index);
        }
        return total + first;
    }

    static int getNumber(char c) {
        return c - 'A' + 1;
    }
}
