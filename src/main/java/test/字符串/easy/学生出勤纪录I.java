package test.字符串.easy;

/**
 * Created by mengyue on 2018/9/27.
 */
public class 学生出勤纪录I {


    public static void main(String[] args) {

    }

    private char absent = 'A';
    private char late = 'L';
    private char present = 'P';

    public boolean checkRecord(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        int aNum = 0;
        char[] chars = s.toCharArray();
        char pre = ' ';
        int preNum = 0;
        for (char c : chars) {
            if (pre == late && c == late) {
                preNum++;
                if (preNum >= 2) {
                    return false;
                }
            } else {
                preNum = 0;
            }
            if (c == absent) {
                aNum++;
                if (aNum > 1) {
                    return false;
                }
            }
            pre = c;
        }
        return true;
    }
}
