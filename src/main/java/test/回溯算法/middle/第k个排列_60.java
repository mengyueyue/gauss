package test.回溯算法.middle;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2019-11-12.
 */
public class 第k个排列_60 {

    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * <p>
     * 说明：
     * <p>
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 示例 1:
     * <p>
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 示例 2:
     * <p>
     * 输入: n = 4, k = 9
     * 输出: "2314"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {


        String s = getPermutation(3, 5);


        System.out.println(s);

    }

//    public static String getPermutation(int n, int k) {
//
//        List<List<Integer>> resultList = new ArrayList<>();
//        int[] v = new int[n];
//        for (int i = 0; i < n; i++) {
//            v[i] = i + 1;
//        }
//
//        backtrack(resultList, new ArrayList<>(), v);
//
//        StringBuffer sb = new StringBuffer();
//
//        for (Integer i : resultList.get(k - 1)) {
//            sb.append(i);
//        }
//
//        return sb.toString();
//    }
//
//    public static void backtrack(List<List<Integer>> resultList, List<Integer> tmpList, int[] nums) {
//        if (tmpList.size() == nums.length) {
//            resultList.add(new ArrayList<>(tmpList));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (tmpList.contains(nums[i])) {
//                    continue;
//                }
//                tmpList.add(nums[i]);
//                backtrack(resultList, tmpList, nums);
//                tmpList.remove(tmpList.size() - 1);
//
//            }
//        }
//    }


    static String getPermutation = "";
    static int result1 = 0;

    public static String getPermutation(int n, int k) {
        if (n == 1) return "1";
        int factor[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
        int sv = k / factor[n - 1];
        k = k % factor[n - 1];
        sv = k > 0 ? sv + 1 : sv;
        if (k == 0) k = factor[n - 1];
        backMethod("", n, k, sv);
        return getPermutation;
    }

    public static void backMethod(String val, int n, int k, int sv) {
        if (!"".equals(getPermutation)) return;
        if (val.length() == n) {
            result1++;
            if (result1 == k && "".equals(getPermutation)) {
                getPermutation = new String(val);
            }
            return;
        } else {
            for (int i = sv; i <= n; i++) {
                if (val.contains(i + "")) {
                    continue;
                }
                backMethod(val + i, n, k, 1);
            }
        }
    }


}
