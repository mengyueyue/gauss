package test.动态规划.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/11/26.
 */
public class 三角形最小路径和 {


    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l1 = new ArrayList<Integer>() {{
            add(2);
        }};
        List<Integer> l2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};
        List<Integer> l3 = new ArrayList<Integer>() {
            {
                add(6);
                add(5);
                add(7);
            }
        };
        List<Integer> l4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(minimumTotal(list));
    }

    //因为只能走相邻的位置 所以上一层(假设index是j)是从下一层的j和j+1的位置而来
    //所以从低向上的遍历的话 triangle.get(i).get(j) 取的是 正在遍历的那层
    //然后  Math.min(A[j], A[j + 1]) 是取 正在遍历的下层的相邻的最小值
    //遍历到倒数第一层的时候 , 她必定和 Math.min(A[0],A[1]) 相加
    //因为越往上 list.size 越小 也就是j越小
    private static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
