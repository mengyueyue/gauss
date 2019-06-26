package test.字符串.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2019-05-16.
 */
public class 自定义字符串排序 {


    public static void main(String[] args) {

    }


    public static String customSortString(String S, String T) {

        Map<Character, Integer> map = new HashMap<>();

        StringBuffer ss = new StringBuffer();


        /**
         *
         * 首先计算 被排序 T的 一个key 对应的values的数量
         *
         *
         */
        for (int i = 0; i < T.length(); i++) {

            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);

        }

        /**
         *
         *
         * 因为 S 是有序的 而且现在我们有T的key value对 ，所以只要遍历 S 取出S对应的T的char 进行 字符串的相加就能得到结果
         *
         */
        for (int i = 0; i < S.length(); i++) {

            int count = map.getOrDefault(S.charAt(i), 0);

            for (int j = 0; j < count; j++) {

                ss.append(S.charAt(i));

            }

            //remove 掉 已经 append的字符串
            map.remove(S.charAt(i));
        }

        //append 剩下的 未存在在S中的字符 因为这部分的排序是无所谓的 所以 append上去 就可以
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            for (int i = 0; i < entry.getValue(); i++) {

                ss.append(entry.getKey());

            }

        }

        return ss.toString();

    }
}
