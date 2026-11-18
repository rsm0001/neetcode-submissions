class Solution {
    // Dynamic programming (DP): reuse solutions to 
    // overlapping subproblems (memoized top-down, or 
    // bottom-up table)
    // If this problem is solved through iteration instead
    // of recursion, space can be used optimally.
    // Constraints on input: 1<=n<=45.
    // n>45 overflows int - when, use of long is required.
    public int climbStairs(int n) {
        if ((n < 1) || (n > 45)) { return -1; }
        if (n <= 2) { return n; }
        int[] memo = new int[] { 1, 2, 0 };
        for (int i=2; i < n; i++) {
            memo[2] = (memo[0] + memo[1]);
            memo[0] = memo[1]; memo[1] = memo[2];
        }
        return memo[2];
    }
}
