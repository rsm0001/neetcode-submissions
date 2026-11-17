class Solution {
    // Dynamic programming requires storing some intermediate results
    private static final List<Integer> list = new ArrayList<>();
    static {
        list.add(0); list.add(1); list.add(2);
    }

    public int climbStairs(int n) {
        if (list.size() > n) { return list.get(n); }
        int res = (climbStairs(n - 1) + climbStairs(n - 2));
        if (list.size() <= n) { list.add(res); }
        return res;
    }
}
