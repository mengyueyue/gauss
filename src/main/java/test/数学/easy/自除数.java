package test.数学.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 自除数 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(selfDividingNumbers(1, 22).toArray()));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean result = true;
            for (char c : String.valueOf(i).toCharArray()) {
                int cc = Integer.valueOf(new String(new char[]{c}));
                if (cc == 0 || i % cc != 0) {
                    result = false;
                }
            }
            if (result) {
                list.add(i);
            }
        }
        return list;
    }
}
