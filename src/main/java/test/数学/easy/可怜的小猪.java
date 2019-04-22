package test.数学.easy;

import static java.lang.Math.*;

/**
 * Created by mengyue on 2018/9/19.
 */
public class 可怜的小猪 {


    public static void main(String[] args) {
        System.out.println(poorPigs(1000, 15, 60));
    }

    /**
     * log(1000) / log(5) = log 以5为低1000的对数
     *
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (minutesToTest < minutesToDie)
            return 0;
        return (int) ceil(log(buckets) / log(floor(minutesToTest / minutesToDie) + 1));
    }
}
