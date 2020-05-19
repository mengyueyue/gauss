package test.数组.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/7/30.
 */
public class 杨辉三角 {


    public static void main(String[] args) {


        while (true) {

            //generate(6);
        }

//        List<List<Integer>> result = generate(5);
//
//        System.out.println(result.toString());
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0)
            return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);

            for (int j = 1; j < res.get(i - 1).size(); j++)
                temp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));

            temp.add(1);
            res.add(temp);
        }

        return res;
    }
}
