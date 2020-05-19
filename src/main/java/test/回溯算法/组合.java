package test.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengyue on 2019-11-07.
 */
public class 组合 {


    public static void main(String[] args) {

        System.out.println(combine(4,2));

    }


    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();

        backtrack(list,1,   n, k, new LinkedList<>());

        return list;

    }


    public static void backtrack(List<List<Integer>> list, int first ,int n, int k, List<Integer> tmpList) {

        if (tmpList.size() == k) {
            list.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = first; i < n +1; i++) {

            tmpList.add(i);

            backtrack( list , i + 1,n , k , tmpList);

            tmpList.remove(tmpList.size()-1);



        }
    }


//    public static void backtrack(List<List<Integer>> output , int first,int n, int k, LinkedList<Integer> curr) {
//        // if the combination is done
//        if (curr.size() == k)
//            output.add(new LinkedList(curr));
//
//        for (int i = first; i < n + 1; ++i) {
//            // add i into the current combination
//            curr.add(i);
//            // use next integers to complete the combination
//            backtrack(output , i + 1, n,k,curr);
//            // backtrack
//            curr.removeLast();
//        }
//    }

}
