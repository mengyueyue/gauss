package test.数学.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengyue on 2018/8/25.
 */
public class 十进制转八进制 {


    public static void main(String[] args) {
        int a = castNum(100);
        System.out.println(a);
    }

    //10进制转换成8进制
    public static int castNum(int key) {
        List<Integer> lists = new LinkedList<>();
        int num = 0;
        boolean flag = true;
        //若是负值则返回-1
        if (key < 0) {
            return -1;
            //若是在0-8之间直接返回当前数
        } else if (key < 8) {
            return key;
        }

        //若是大于等于8则进行转换
        while (flag) {
            //取余
            num = key % 8;
            //添加进集合
            lists.add(num);
            //取整数商
            key = key / 8;
            //当k=0时，跳出循环
            if (key == 0) {
                flag = false;
            }
        }
        //跳出循环就进行转换
        if (!flag) {
            //集合反转
            Collections.reverse(lists);
            StringBuffer sb = new StringBuffer();
            for (int l : lists) {
                //转换成StringBuffer
                sb.append(l);
            }
            //转换成int型
            key = Integer.parseInt(new String(sb));
        }
        return key;
    }
}
