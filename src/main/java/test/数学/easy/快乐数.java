package test.数学.easy;

import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 快乐数 {


    public static void main(String[] args) {

        System.out.println(isHappy(19));
    }

//    public static boolean isHappy(int n) {
//        while (n != 1 && n != 4) {
//            int t = 0;
//            while (n!=0) {
//                t += (n % 10) * (n % 10);
//                n /= 10;
//            }
//            n = t;
//        }
//        return n == 1;
//    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int total = 0;
        while (n != 1) {
            while (n != 0) {
                total += (n % 10) * (n % 10);
                n /= 10;
            }
            n = total;
            total = 0;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

}
