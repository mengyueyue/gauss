package test.回溯算法.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengyue on 2019-11-11.
 */
public class 电话号码的字母组合_17 {


    public static void main(String[] args) {

    }


    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList();

        Map<String, Character[]> map = new HashMap<>();

        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};


        backtrack(result , phone);

        return result;
    }


    public static void backtrack(List<String> result, Map<String, String> phone) {



    }
}
