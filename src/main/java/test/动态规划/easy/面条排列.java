package test.动态规划.easy;

import java.util.*;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 面条排列 {


    private static TreeSet<Integer> set = new TreeSet<>();

    private static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {
        input();
    }

    public static int input() {
        int i = 1;
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (i == 1) {
                N = scanner.nextInt();
            } else {
                if (N != 0) {
                    String[] s = scanner.nextLine().split("  ");
                    int a = Integer.valueOf(s[0]);
                    int b = Integer.valueOf(s[1]);
                    int tmp = 0;
                    if (a > b) {
                        tmp = b;
                        b = a;
                        a = tmp;
                    }
                    set.add(a);
                    set.add(b);
                    map.put(a, b);
                    N--;
                } else {
                    break;
                }
            }
        }
        return getBestNumber();
    }


    public static int getBestNumber() {
        Integer[] array = set.toArray(new Integer[set.size()]);
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int m = 0;
            int key = array[i];
            while (j != array[array.length - 1]) {
                if (map.containsKey(key)) {
                    key = map.get(key);
                    j = key;
                    m++;
                } else {
                    key = ++j;
                }
            }
            max = Math.max(max, m);
        }
        return max;
    }
}
