package test.位运算.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2019-05-21.
 */
public class 二进制表示中质数个计算置位 {


    public static void main(String[] args) {

    }

    public static int countPrimeSetBits(int L, int R) {

        int ans = 0;

        for (int i = L; i <= R; i++) {

            int tmp = i;
            int cnt = 0;
            while (tmp > 0) {
                tmp &= tmp - 1;
                cnt++;

            }
            ans = isPrime(cnt) ? ans + 1 : ans;

        }

        return ans;
    }


    private static boolean isPrime(int a) {
        Set<Integer> set = new HashSet<Integer>() {{
            add(2);
            add(3);
            add(5);
            add(7);
            add(11);
            add(13);
            add(17);
            add(19);
            add(23);
            add(29);
            add(31);
        }};
        return set.contains(a);
    }
}
