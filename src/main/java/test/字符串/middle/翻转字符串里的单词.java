package test.字符串.middle;


/**
 * Created by mengyue on 2018/10/13.
 */
public class 翻转字符串里的单词 {


    public static void main(String[] args) {
        System.out.println(reverseWords(""));
    }


    public static String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        StringBuffer sb = new StringBuffer();
        for (int i = array.length - 1; i > 0; i--) {
            sb.append(array[i]).append(" ");
        }
        sb.append(array[0]);
        return sb.toString();
    }
}
