package 字符串.middle;


import java.util.Stack;

/**
 * Created by mengyue on 2018/8/1.
 */
public class 基本计算器II {


    public static void main(String[] args) {
        //System.out.println(calculate("1 * 21 / 23 / 3 - 2 + 2 * 2 + 3 / 3 / 2 * 1 + 1 + 1 * 2 / 1"));
        //System.out.println(calculate("1 * 21 / 23 / 3 - 2 "));
        System.out.println(calculate("12-3*4"));

        //System.out.println(1 * 21 / 23 / 3 - 2 + 2 * 2 + 3 / 3 / 2 * 1 + 1 + 1 * 2 / 1);
        System.out.println(1 * 21 / 23 / 3 - 2);
    }

    public static int calculate(String str) {
        Integer a = 0;
        for (Integer integer : returnStack(str)) {
            a += integer;
        }
        return a;
    }

    public static Stack<Integer> returnStack(String str) {

        Stack<Integer> stack = new Stack<Integer>();
        boolean neg = false;
        String preOp = "";
        boolean cgneg = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            String s = String.valueOf(aChar);
            if (" ".equals(s)) {
                continue;
            }
            if ("-".equals(s)) {
                neg = true;
                continue;
            }
            if (neg) {
                s = "-" + s;
                neg = false;
            }
            Integer a;
            if (s.startsWith("-")) {
                cgneg = true;
            }

            if ((int) '0' <= aChar && aChar <= (int) '9') {
                a = Integer.valueOf(cycStr(i, chars, ""));
                i += a.toString().length() > 1 ? a.toString().length() - 1 : 0;
                if (cgneg) {
                    a = -a;
                    cgneg = false;
                }
                stack.push(a);
            }
            if ("*".equals(preOp)) {
                Integer result = stack.pop() * stack.pop();
                stack.push(result);
                preOp = "";
            }
            if ("/".equals(preOp)) {
                Integer diffed = stack.pop();
                Integer diff = stack.pop();
                stack.push(diff / diffed);
                preOp = "";
            }
            if ("*".equals(s) || "/".equals(s)) {
                preOp = s;
            }
        }
        return stack;
    }

    public static String cycStr(int i, char[] chars, String s) {
        for (; ; ) {
            if (i < chars.length && (int) '0' <= chars[i] && chars[i] <= (int) '9') {
                s += chars[i];
                i += 1;
            } else {
                break;
            }
        }
        return s;
    }


    /**
     * 传入i+1
     *
     * @param i
     * @param chars
     * @return
     */
//    public static String cycStr(int i, char[] chars, String s) {
//        if (i <= chars.length - 1 && (int) '0' <= chars[i] && chars[i] <= (int) '9') {
//            cycStr(i + 1, chars, s += chars[i]);
//        }
//        return s;
//    }


//    public static int calculate(String str) {
//        int temp = 0;
//        String strTemp = "";
//        //前一个数字
//        String preStr = "";
//        String[] calArray = new String[3];
//        boolean cal = false;
//        for (char c : str.toCharArray()) {
//            String s = String.valueOf(c);
//            if (" ".equals(s)) {
//                continue;
//            }
//            //是数字
//            if ((int) '0' <= c && c <= (int) '9') {
//                preStr = s;
//            }
//            if ("*".equals(s) || "/".equals(s)) {
//
//            }
//
//
//        }
//        return 0;
//    }
}
