package test.堆.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengyue on 2018/11/6.
 */
public class 根据字符出现频率排序 {


    public static void main(String[] args) {

    }


    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character>[] list = new ArrayList[s.length() + 1];
        for (Character c : map.keySet()) {
            int value = map.get(c);
            if(list[value] == null){
                list[value] = new ArrayList<>();
            }
            list[value].add(c);

        }
        StringBuffer sb = new StringBuffer();
        for (int i = list.length -1 ; i >=0 ; i--) {
            if(list[i] != null){
                for (Character c : list[i]) {
                    for (int j = 0; j < map.get(c) ; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
