package dynamic_programming;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divideand conquer approach,
 * which is more subtle.
 */

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = 0;
        for(int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], nums[i] + sum[i-1]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}
