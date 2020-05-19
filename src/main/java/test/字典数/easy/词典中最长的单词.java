package test.字典数.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2019/3/22.
 */
public class 词典中最长的单词 {


    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"1", "2"}));
    }


    public static String longestWord(String[] array) {

        Arrays.sort(array);

        Set<String> res = new HashSet<>();

        res.add("");

        String longestWord = "";

        for (String s : array) {

            if (res.contains(s.substring(0, s.length() - 1))) {
                res.add(s);

                if (s.length() > longestWord.length()) {
                    longestWord = s;
                }
            }
        }

        return longestWord;

    }
}
