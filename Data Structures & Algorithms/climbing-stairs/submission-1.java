class Solution {
    // Dynamic programming requires storing some intermediate results
    private static final Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1, 1); map.put(2, 2);
    }

    public int climbStairs(int n) {
        if (map.containsKey(n)) { return map.get(n); }
        int res = (climbStairs(n - 1) + climbStairs(n - 2));
        map.put(n, res);
        return res;
    }
}
