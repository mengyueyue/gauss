package test.数组.middle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mengyue on 2018/10/4.
 */
public class 常数时间插入删除和获取随机元素 {

    public static void main(String[] args) {
        
    }
}


class RandomizedSet {
    /**
     * key is value, value is index
     */
    private HashMap<Integer, Integer> map;
    /**
     * store all vals
     */
    private ArrayList<Integer> nums;
    private java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);

        if (contain)
            return false;

        map.put(val, nums.size());
        nums.add(val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain)
            return false;

        int valIndex = map.get(val);
        // if this val is not the last one
        if (valIndex != nums.size() - 1) {
            // copy the last one value into this val's position
            int lastNum = nums.get(nums.size() - 1);
            nums.set(valIndex, lastNum);
            // update the lastNum index in map
            map.put(lastNum, valIndex);
        }
        // only remove last one is O(1)
        map.remove(val);
        nums.remove(nums.size() - 1);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}