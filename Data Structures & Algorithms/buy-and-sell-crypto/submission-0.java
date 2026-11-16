class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0, l = 0, r = 1;
        while (r < prices.length) {
            maxp = Math.max(maxp, (prices[r] - prices[l]));
            if (prices[r] < prices[l]) { l = r; }
            r++;
        }
        return maxp;
    }
}
