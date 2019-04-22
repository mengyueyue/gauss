package test.数学.easy;

import java.util.Stack;

/**
 * Created by mengyue on 2018/8/25.
 */
public class 十进制转四进制 {
    public static void main(String[] args) {
        System.out.println(castNum(-99));
    }

    public static int castNum(int key) {
        boolean neg = key <= 0;
        if (-4 < key && key < 4) {
            return neg ? -key : key;
        }
        key = key > 0 ? key : -key;
        Stack<Integer> stack = new Stack<>();
        while (key != 0) {
            int rem = key % 4;
            stack.push(rem);
            key /= 4;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        int result = Integer.valueOf(sb.toString());
        return neg ? -result : result;
    }
}
