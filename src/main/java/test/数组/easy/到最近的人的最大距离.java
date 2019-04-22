package test.数组.easy;

/**
 * Created by mengyue on 2018/9/16.
 */
public class 到最近的人的最大距离 {

    public static void main(String[] args) {

        int[] seats = new int[]{1, 0, 1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        int start = 0, end = seats.length - 1;
        int tmpS = 0, tmpE = 0, tmp = 0;
        while (true) {
            if (seats[start] == 0) {
                start++;
                tmpS++;
                continue;
            }
            max = tmpS;
            if (seats[end] == 0) {
                end--;
                tmpE++;
                continue;
            }
            max = Math.max(max, tmpE);
            break;
        }
        if (max > (seats.length + 1) / 2) {
            return max;
        }
        for (int i = start; i <= end; i++) {
            if (seats[i] == 0) {
                tmp++;
            } else {
                max = Math.max(max, (tmp + 1) / 2);
                tmp = 0;
            }
        }
        return max;
    }
}

