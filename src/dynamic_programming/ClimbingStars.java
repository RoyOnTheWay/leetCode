package dynamic_programming;

public class ClimbingStars {
    /**
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     * Once you pay the cost, you can either climb one or two steps.
     * You need to find minimum cost to reach the top of the floor,
     * and you can either start from the step with index 0, or the step with index 1.
     *
     * Example 1:
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length+1];
        res[0] = 0;
        res[1] = 0;
        res[2] = Math.min(cost[0], cost[1]);
        for(int i = 3; i < res.length; i++) {
            res[i] = Math.min(cost[i-1] + res[i-1], cost[i-2] + res[i-2]);
        }
        return res[res.length-1];
    }

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * Note: Given n will be a positive integer.
     *
     * Example 1:
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     */

    public int climbStairs(int n) {
        int[] res = new int[n+1];
        if (n == 1) return 1;
        res[1] = 1;
        res[2] = 2;
        for(int i = 3; i < n+1; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        int[] test = new int[]{10, 15, 20};
        ClimbingStars cs = new ClimbingStars();
        System.out.println(cs.minCostClimbingStairs(test));
    }
}
