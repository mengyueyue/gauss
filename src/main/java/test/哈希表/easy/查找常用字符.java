package test.哈希表.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mengyue on 2019-05-13.
 */
public class 查找常用字符 {


    public static void main(String[] args) {


        List<String> result = commonChars(new String[]{"bella", "label", "roller"});

        System.out.println(result.toString());

    }

    /**
     * 每一个 string 都会创建一个26大小的数组 然后每一个位置上存一个字符 出现在一个字符串中的count数量
     * <p>
     * 也就是例如 [1,0,0,2,0] 这样
     *
     * @param A
     * @return
     */

    public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                /**
                 *
                 * 这里取每个字符串 在相同位置的交集(也就是相同字符)
                 *
                 * 最小值的原因是：再取交集的时候 有两种情况
                 *
                 * 1.在每个字符串中取的数 假设为： 0,1,0,2 这样他们最终是没有交集的 所以对应index 应该标记为 0
                 *
                 * 2.在每个字符串中取的数 假设为： 1,4,1,2 这样他们是有交集的 是取min 所以对应的index 应该标记为 1
                 *
                 *
                 */
                res[j] = Math.min(res[j], temp[j]);
            }
        }
        /**
         *
         * 在确定是那些 字符有差异的情况下
         *
         * 我们还需要知道 是那个值有差异 以及 它的取值为多少 以及它的index是多少 因为值的还原是靠 'a' + 这个值的index 得出的
         *
         * 因为我们在上面存的时候 用了 tmp[c - 'a']++ 这样的写法
         *
         */
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                for (int j = 0; j < res[i]; j++) {
                    list.add(((char) ('a' + i) + ""));
                }
            }
        }
        return list;
    }

}
