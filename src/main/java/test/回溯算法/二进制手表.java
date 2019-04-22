package test.回溯算法;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/13.
 */
public class 二进制手表 {


    public static void main(String[] args) {


        System.out.println(Arrays.toString(readBinaryWatch(2).toArray()));

        //System.out.println(Integer.bitCount(3));
    }

    public static List<String> readBinaryWatch(int num) {

        List<String> ans = new ArrayList<>();
        // Hours iterate from 0-11 and
        // Minutes iterate from 0-59.

        // See for which values, number of 1's match
        // with the value <num> provided.
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // Number of set bits in hour portion and in minute
                // part has to be equal to num.
                if (Integer.bitCount(h)
                        + Integer.bitCount(m) == num) {
                    ans.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return ans;
    }
}
