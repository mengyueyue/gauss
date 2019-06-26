package test.数组.easy;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mengyue on 2018/9/16.
 */
public class 种花问题 {


    public static void main(String[] args) {


        int[] arrays = {1, 0, 0, 0, 1, 0, 0};

        System.out.println(canPlaceFlowers(arrays, 2));

    }

    /**
     *
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     *
     * 示例 1:
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     * 示例 2:
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     * 注意:
     *
     * 数组内已种好的花不会违反种植规则。
     * 输入的数组长度范围为 [1, 20000]。
     * n 是非负整数，且不会超过输入数组的大小。
     *
     *
     * @param flowerbed
     * @param n
     * @return
     */

    /**
     *
     *
     * 这样做的好处是 不用判断 各种边界条件 以及 避免出现数组下标越界
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int[] arrays = new int[flowerbed.length + 2];
        arrays[0] = 0;
        arrays[arrays.length - 1] = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            arrays[i + 1] = flowerbed[i];
        }

        for (int i = 1; i < arrays.length - 1; i++) {
            if (arrays[i - 1] == 0 && arrays[i] == 0 && arrays[i + 1] == 0) {
                arrays[i] = 1;
                n -= 1;
            }
        }
        return n <= 0;
    }
}
