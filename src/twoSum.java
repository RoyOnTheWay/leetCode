import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 * You may assume that each input would have exactly one solution, and you may not use the same element twice.

 * Example:

 * Given nums = [2, 7, 11, 15], target = 9,

 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum test = new twoSum();
        int[] ary = new int[4];
        ary[0] = 2;
        ary[1] = 7;
        ary[2] = 11;
        ary[3] = 15;
        int[] res = test.twoSum(ary, 9);
        System.out.println("Answer: " + res[0] + ", " + res[1]);
    }
}
