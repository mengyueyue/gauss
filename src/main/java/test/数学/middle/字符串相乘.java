package test.数学.middle;


/**
 * Created by mengyue on 2018/8/25.
 */
public class 字符串相乘 {

    public static void main(String[] args) {
        String a = "99";
        String b = "99";
        System.out.println(99 * 99);
        System.out.println(multiply(a, b));
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int result = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i + j, pos2 = i + j + 1;
                result += pos[pos2];
                pos[pos2] = result % 10;
                pos[pos1] += result / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}


//      for (int i = m - 1; i >= 0; i--) {
//         for (int j = n - 1; j >= 0; j--) {
//         int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//         int p1 = i + j, p2 = i + j + 1;
//         int sum = mul + pos[p2];
//
//         pos[p1] += sum / 10;
//         pos[p2] = (sum) % 10;
//          }
//       }