package test.easy;


import org.junit.Assert;

/**
 * Created by mengyue on 2018/7/25.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
 * <p>
 * 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "UD"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "LL"
 * 输出: false
 */
public class 判断路线成圈 {

    public static void main(String[] args) {

        String path = "LRUD";
        Assert.assertEquals(self(path), other(path));

    }


    /**
     * 别人的答案
     */
    public static boolean other(String moves) {
        char[] move = moves.toCharArray();
        char[] count = new char[100];

        for (char c : move) {
            count[c]++;
        }
        return count['U'] == count['D'] && count['L'] == count['R'];
    }


    /**
     * 自己的答案
     *
     * @param moves
     * @return
     */
    public static boolean self(String moves) {
        int level = 0;
        int vertical = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int tmp = c == 'L' ? level++ : c == 'R' ? level-- : c == 'U' ? vertical++ : c == 'D' ? vertical-- : 0;
        }
        return (level | vertical) == 0;
    }

}
