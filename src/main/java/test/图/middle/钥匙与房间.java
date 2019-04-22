package test.图.middle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by mengyue on 2018/9/5.
 */
public class 钥匙与房间 {

    public static void main(String[] args) {

    }


    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.add(0);
        set.add(0);
        while (!stack.isEmpty()) {
            //出栈了 相当于删掉了
            int i = stack.pop();
            List<Integer> list = rooms.get(i);
            for (int j = 0; j < list.size(); j++) {
                int k = list.get(j);
                if (!set.contains(k)) {
                    set.add(k);
                    stack.push(k);
                }
            }
        }
        return rooms.size() == set.size();
    }
}
