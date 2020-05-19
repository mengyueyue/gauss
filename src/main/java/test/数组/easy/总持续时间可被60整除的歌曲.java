package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-07-16.
 */
public class 总持续时间可被60整除的歌曲 {


    public static void main(String[] args) {


        int[] time = {60};

        System.out.println(numPairsDivisibleBy60(time));
    }

    public static int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        //2.方法二：创建一个包含六十个元素的数组，将模60的结果存入
        int temp[] = new int[60];
        for (int i = 0; i < time.length; i++) {
            temp[time[i] % 60]++;
        }
        System.out.println(Arrays.toString(temp));

        int temp3 = 0;
        for(int i = 0; i < temp.length; i++){
            if(i == 0 || i == 30){
                int temp2 = temp[i] * (temp[i] - 1) / 2;
                count += temp2;
                continue;
            }
            temp3 += temp[i] * temp[60 - i] % 2; //解决类似i = 20 和i = 39的重复问题。不能少哦
            int temp2 = temp[i] * temp[60 - i] / 2;
            count += temp2;
        }

        return count + temp3 / 2;
    }
}
