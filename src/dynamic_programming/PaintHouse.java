package dynamic_programming;

import sun.applet.Main;

/**
 * There are a row of n houses, each house can be painted with one of the three colors:
 * red, blue or green. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.

 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Example:

 Input: [[17,2,17],[16,16,5],[14,3,19]]
 Output: 10
 Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 Minimum cost: 2 + 5 + 3 = 10.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] cost = new int[n][3];
        cost[0][0] = Math.min(costs[0][1], costs[0][2]);
        cost[0][1] = Math.min(costs[0][0], costs[0][2]);
        cost[0][2] = Math.min(costs[0][0], costs[0][1]);
        for (int i = 1; i < costs.length; i++) {
            cost[i][0] = Math.min(costs[i][1] + cost[i-1][1],
                                  costs[i][2] + cost[i-1][2]);
            cost[i][1] = Math.min(costs[i][0] + cost[i-1][0],
                                  costs[i][2] + cost[i-1][2]);
            cost[i][2] = Math.min(costs[i][1] + cost[i-1][1],
                                  costs[i][0] + cost[i-1][0]);
        }
        return Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]);
    }

    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        int[][] costs =
                {{3,5,3},
                {6,17,6},
                {7,13,18},
                {9,10,18}};
        System.out.println(ph.minCost(costs));
    }
}
