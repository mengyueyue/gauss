package test.数学.easy;

/**
 * Created by mengyue on 2018/8/25.
 */
public class 丑数 {


    public static void main(String[] args) {

        System.out.println(27 % 3);
    }

    public boolean isUgly(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}
