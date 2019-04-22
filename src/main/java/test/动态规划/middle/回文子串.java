package test.动态规划.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/20.
 */
public class 回文子串 {


    /**
     * 相当于先求出所有的子串 然后在调用查看子串是否是回文的方法
     */
    public static void main(String[] args) {


    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static boolean isPalindrome(String x) {
        char[] chars = String.valueOf(x).toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


//    int count = 1;

//    public int countSubstrings(String s) {
//        if (s.length() == 0)
//            return 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            //To check the palindrome of odd length palindromic sub-string
//            checkPalindrome(s, i, i);
//            //To check the palindrome of even length palindromic sub-string
//            checkPalindrome(s, i, i + 1);
//        }
//        return count;
//    }
//
//    private void checkPalindrome(String s, int i, int j) {
//        //Check for the palindrome string
//        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
//            count++;    //Increment the count if palindromin substring found
//            i--;    //To trace string in left direction
//            j++;    //To trace string in right direction
//        }
//    }

}
