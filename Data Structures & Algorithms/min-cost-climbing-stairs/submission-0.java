class Solution {
    // Dynamic programming (DP): reuse solutions to 
    // overlapping subproblems (memoized top-down, or 
    // bottom-up table)

    // Constraints for this problem:
    // 2 <= cost.length <= 100
    // 0 <= cost[i] <= 100

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) { return -1; }
        int[] memo = new int[] { 0, 0, 0 };
        for (int i=2; i <= cost.length; i++) {
            memo[2] = Math.min((memo[0] + cost[i-2]), (memo[1] + cost[i-1]));
            memo[0] = memo[1]; memo[1] = memo[2];
        }
        return memo[2];
    }
}
