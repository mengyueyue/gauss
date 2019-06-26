package test.栈.middle;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mengyue on 2019-05-15.
 */
public class 行星碰撞 {


    public static void main(String[] args) {

        int[] asteroids = new int[]{10, 2, -5};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }


    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (stack.empty() || stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else if (stack.peek() <= -asteroids[i]) {
                // 这里回退一位 很有意思 i 减一位 上面 i 加一位 相当于 i 不变 下次循环还在处理 上次循环的问题
                if (stack.peek() < -asteroids[i]) --i;
                stack.pop();
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }

}
