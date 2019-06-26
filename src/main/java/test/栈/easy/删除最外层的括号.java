package test.栈.easy;

import java.util.Stack;

/**
 * Created by mengyue on 2019-05-20.
 */
public class 删除最外层的括号 {

    /**
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
     * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     * <p>
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     * <p>
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * <p>
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * 示例 2：
     * <p>
     * 输入："(()())(())(()(()))"
     * 输出："()()()()(())"
     * 解释：
     * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
     * 示例 3：
     * <p>
     * 输入："()()"
     * 输出：""
     * 解释：
     * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
     * 删除每个部分中的最外层括号后得到 "" + "" = ""。
     * <p>
     * <p>
     * 提示：
     * <p>
     * S.length <= 10000
     * S[i] 为 "(" 或 ")"
     * S 是一个有效括号字符串
     *
     * @param args
     */
    public static void main(String[] args) {



    }

    public static String removeOuterParentheses(String S) {

        Stack<Character> stack = new Stack<>();

        StringBuffer ss = new StringBuffer();

        for (int i = 0; i < S.length(); i++) {

            if ('(' == S.charAt(i)) {

                if (stack.isEmpty()) {

                    //这个是最外层的( 是要被delete掉的
                    stack.push(S.charAt(i));

                } else {
                    //不是最外层的也 要放进去 以便和后面的 ) 来做匹配
                    stack.push(S.charAt(i));
                    ss.append(S.charAt(i));
                }

            } else {
                //pop 掉 stack 最上层的 对象
                stack.pop();
                //如果 pop完 左括号后 还有剩余 但就表明 pop掉的还不是最外面的括号 然后将pop出的括号 append在 stringbuffer中
                if (!stack.isEmpty()) {
                    ss.append(S.charAt(i));
                }

            }
        }

        return ss.toString();
    }
}
