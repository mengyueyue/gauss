package test.数组.easy;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 一比特与二比特字符 {

    public static void main(String[] args) {

    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (i = 0; i < bits.length - 1; ) {
            if (bits[i] == 0) {
                i++;
            } else
                i += 2;
        }
        System.out.println(i);
        return i == bits.length - 1;
    }
}
