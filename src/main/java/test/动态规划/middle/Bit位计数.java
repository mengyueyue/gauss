package 动态规划.middle;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/7/30.
 */
public class Bit位计数 {


    public static void main(String[] args) {

        //System.out.println(Arrays.toString(countBits(5)));

    }

//    public static int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        result[0] = 0;
//        if (num == 0) {
//            return result;
//        }
//        for (int i = 1; i <= num; i++) {
//            result[i] = result[i & i - 1] + 1;//会先算 i-1 再算 &
//        }
//        return result;
//    }


//    public static int[] countBits(int num) {
//        int[] ret = new int[num + 1];
//        ret[0] = 0;
//        for (int i = 1; i <= num; ++i) {
//            ret[i] = ret[i >> 1] + (i & 1); // 按位与&的优先级小于+, 所以要加括号!!
//        }
//        return ret;
//    }
}
